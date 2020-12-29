package com.example.projetandroid_kotlin_4a.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projetandroid_kotlin_4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> {
                    TODO()
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Incorrect login or password")
                        .setPositiveButton("ok") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        Login_button.setOnClickListener{
            if(login_text.text.toString().trim().equals("") || password_text.text.toString().trim().equals("")){
                MaterialAlertDialogBuilder(this)
                    .setTitle("Error")
                    .setMessage("Login or password is empty")
                    .setPositiveButton("ok") { dialog, which ->
                        dialog.dismiss()
                    }
                    .show()
            }else{
                mainViewModel.onClickedLogin(login_text.text.toString().trim(), password_text.text.toString().trim())
            }
        }
    }
}