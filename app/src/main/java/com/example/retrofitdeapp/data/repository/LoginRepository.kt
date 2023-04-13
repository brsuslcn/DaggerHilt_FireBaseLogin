package com.example.retrofitdeapp.data.repository

import com.example.retrofitdeapp.data.remote.Services
import com.example.retrofitdeapp.data.model.UserModel
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiService : Services) {
    suspend fun loginUser(userModel: UserModel) : Response<UserModel>{
        return apiService.login(userModel)
    }
}