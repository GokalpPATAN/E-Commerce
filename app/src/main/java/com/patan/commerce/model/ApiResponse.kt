package com.patan.commerce.model


import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("Data") val `data`: T?,
    @SerializedName("Message") val message: Any?,
    @SerializedName("MessageSeverity") val messageSeverity: Int?,
    @SerializedName("IsSuccess") val ısSuccess: Boolean?
)