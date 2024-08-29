package com.patan.commerce.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("Email") val email: String?,
    @SerializedName("Name") val name: String?,
    @SerializedName("PhoneNumber") val phoneNumber: String?,
    @SerializedName("Surname") val surname: String?,
    @SerializedName("Token") val token: String?,
    @SerializedName("Gender") val gender: String?,
    @SerializedName("Password") val password: String?,
    @SerializedName("RePassword") val rePassword: String?,
    @SerializedName("UserName") val userName: String?
)