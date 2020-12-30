package com.example.projetandroid_kotlin_4a.presentation.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetandroid_kotlin_4a.domain.entity.User
import com.example.projetandroid_kotlin_4a.domain.usecase.CreateUserUseCase
import com.example.projetandroid_kotlin_4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateAccountViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){
    val  createLiveData : MutableLiveData<CreateStatus> = MutableLiveData()

    fun onClickedCreate(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user : User? =  getUserUseCase.invoke(emailUser, password)
            val createStatus = if(user == null){
                createUserUseCase.invoke(User(emailUser,password))
                CreateSuccess
            }else{
                CreateError
            }

            withContext(Dispatchers.Main){
                createLiveData.value = createStatus
            }
        }
    }
}