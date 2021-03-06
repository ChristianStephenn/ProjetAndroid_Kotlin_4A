package com.example.projetandroid_kotlin_4a.injection

import android.content.Context
import androidx.room.Room
import com.example.projetandroid_kotlin_4a.data.local.AppDatabase
import com.example.projetandroid_kotlin_4a.data.local.DatabaseDao
import com.example.projetandroid_kotlin_4a.data.repository.UserRepository
import com.example.projetandroid_kotlin_4a.domain.usecase.CreateUserUseCase
import com.example.projetandroid_kotlin_4a.domain.usecase.GetUserUseCase
import com.example.projetandroid_kotlin_4a.presentation.account.CreateAccountViewModel
import com.example.projetandroid_kotlin_4a.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get(), get()) }
    factory { CreateAccountViewModel(get(),get()) }
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
    single { UserRepository(get()) }
    single { CreateDatabase(androidContext())}
}

fun CreateDatabase(context: Context): DatabaseDao {
    val appDatabase : AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}
