package com.example.retrofitdeapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitdeapp.data.model.UserModel
import com.example.retrofitdeapp.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.retrofitdeapp.data.helper.Result




@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginResult = MutableLiveData<Result<Unit>>(Result.Loading)
    val loginResult : LiveData<Result<Unit>> = _loginResult


    fun loginUser(userModel: UserModel){

        viewModelScope.launch {
            val response = loginRepository.loginUser(userModel)
            if(response.isSuccessful){
                Log.e("LOGIN", "Login Successfull")
                _loginResult.value = Result.Success(Unit)
            }

            else
            {
                Log.e("LOGIN", "Login Failed")
                Log.e("Gelen yanıt:",response.toString())
                _loginResult.value = Result.Error(Exception("Login Failed"))

            }
        }
    }

}