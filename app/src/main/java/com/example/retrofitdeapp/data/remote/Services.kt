package com.example.retrofitdeapp.data.remote

import com.example.retrofitdeapp.data.model.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Services {

 @POST("v1/accounts:signInWithPassword?key=/*YOUR KEY HERE*/")
 suspend fun login(@Body userModel: UserModel) : Response<UserModel>
}