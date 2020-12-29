package com.example.projetandroid_kotlin_4a.presentation.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projetandroid_kotlin_4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_create_account.*
import org.koin.android.ext.android.inject

class CreateAccountActivity : AppCompatActivity() {

    val createAccountViewModel : CreateAccountViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        createAccountViewModel.createLiveData.observe(this, Observer {
            when (it) {
                CreateSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Success")
                        .setMessage("Account created.")
                        .setPositiveButton("ok") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                CreateError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Account already exists.")
                        .setPositiveButton("ok") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        Create_button.setOnClickListener {
            if (create_login_text.text.toString().trim() == "" || create_password_text.text.toString().trim() == ""
            ) {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Error")
                    .setMessage("Login or password is empty")
                    .setPositiveButton("ok") { dialog, which ->
                        dialog.dismiss()
                    }
                    .show()
            } else {
                createAccountViewModel.onClickedCreate(
                    create_login_text.text.toString().trim(),
                    create_password_text.text.toString().trim()
                )

            }
        }
    }
}