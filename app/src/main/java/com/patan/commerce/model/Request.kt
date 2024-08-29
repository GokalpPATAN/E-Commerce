package com.patan.commerce.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("UserName") val userName: String?,
    @SerializedName("Password") val password: String?
)

data class ConfirmRequest(
    @SerializedName("ApprovedCode") val approvedCode: Int?,
    @SerializedName("Token") val token: String?,
    @SerializedName("UserName") val userName: String?
)

data class RegisterRequest(
    @SerializedName("Email") val email: String?,
    @SerializedName("Gender") val gender: String?,
    @SerializedName("Name") val name: String?,
    @SerializedName("Password") val password: String?,
    @SerializedName("PhoneNumber") val phoneNumber: String?,
    @SerializedName("RePassword") val rePassword: String?,
    @SerializedName("Surname") val surname: String?,
    @SerializedName("UserName") val userName: String?
)

data class ReConfirmRequest(
    @SerializedName("UserName") val userName: String?
)
