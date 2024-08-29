package com.patan.commerce.model


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("Data")
    val `data`: Data?,
    @SerializedName("Message")
    val message: Any?,
    @SerializedName("MessageSeverity")
    val messageSeverity: Int?,
    @SerializedName("IsSuccess")
    val ısSuccess: Boolean?
)