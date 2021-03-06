package com.example.projetandroid_kotlin_4a.data.repository

import com.example.projetandroid_kotlin_4a.data.local.DatabaseDao
import com.example.projetandroid_kotlin_4a.data.local.models.UserLocal
import com.example.projetandroid_kotlin_4a.data.local.models.toData
import com.example.projetandroid_kotlin_4a.data.local.models.toEntity
import com.example.projetandroid_kotlin_4a.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
){

    fun createUser(user : User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String, password : String) : User? {
        val userLocal : UserLocal? = databaseDao.findByName(email, password)
        return userLocal?.toEntity()
    }
}