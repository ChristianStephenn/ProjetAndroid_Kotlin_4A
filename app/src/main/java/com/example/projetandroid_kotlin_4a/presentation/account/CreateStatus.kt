package com.example.projetandroid_kotlin_4a.presentation.account

sealed class CreateStatus

object CreateSuccess : CreateStatus()
object CreateError : CreateStatus()