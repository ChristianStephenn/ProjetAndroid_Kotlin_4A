package com.example.projetandroid_kotlin_4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetandroid_kotlin_4a.domain.entity.User
import com.example.projetandroid_kotlin_4a.domain.usecase.CreateUserUseCase
import com.example.projetandroid_kotlin_4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val  loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user : User? =  getUserUseCase.invoke(emailUser, password)
            //createUserUseCase.invoke(User("test"))
            val loginStatus = if(user != null){
                LoginSuccess(user.email, user.password)
            }else{
                LoginError
            }

            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }
}