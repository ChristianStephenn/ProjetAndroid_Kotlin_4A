package com.example.projetandroid_kotlin_4a.injection

import com.example.projetandroid_kotlin_4a.MainViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel() }
}