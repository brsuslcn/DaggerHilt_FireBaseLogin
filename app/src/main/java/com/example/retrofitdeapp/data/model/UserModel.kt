package com.example.retrofitdeapp.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    val email : String,
    val password : String,
    @SerializedName("returnSecureToken") val returnSecureToken: Boolean = true
)