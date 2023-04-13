package com.example.retrofitdeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.retrofitdeapp.ui.viewmodel.LoginViewModel

import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import com.example.retrofitdeapp.data.model.UserModel
import com.example.retrofitdeapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.retrofitdeapp.data.helper.Result



@AndroidEntryPoint
class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var binding: ActivityMainBinding
    private val loginViewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.apply{

            btnLogin.setOnClickListener()
            {
                if(edEmail.text.toString().isNullOrBlank() || edPass.text.toString().isNullOrBlank())
                {
                    Toast.makeText(applicationContext,"Please enter valid e-mail and password!", Toast.LENGTH_SHORT).show()
                }

                else
                {
                    val newLogin = UserModel(edEmail.text.toString(), edPass.text.toString())
                    loginViewModel.loginUser(newLogin)

                }

            }
        }

        loginViewModel.loginResult.observe(this, { result ->
            when (result) {
                is Result.Loading -> {
                    // İşlem yürütülüyor, bir şey yapmanıza gerek yok
                }
                is Result.Success -> {
                    Toast.makeText(applicationContext, "Login Succesful!", Toast.LENGTH_SHORT).show()
                }
                is Result.Error -> {
                    Toast.makeText(applicationContext, "Incorrect E-Mail or Password!", Toast.LENGTH_SHORT).show()
                }
            }
        })




    }



}



