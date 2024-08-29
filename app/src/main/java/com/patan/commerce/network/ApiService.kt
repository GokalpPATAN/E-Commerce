package com.patan.commerce.network

import com.patan.commerce.model.ApiResponse
import com.patan.commerce.model.ConfirmRequest
import com.patan.commerce.model.LoginRequest
import com.patan.commerce.model.ReConfirmRequest
import com.patan.commerce.model.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("Authentication/Login")
    suspend fun userLogin(@Body request: LoginRequest): Response<ApiResponse>

    @POST("Authentication/Register")
    suspend fun userRegister(@Body request: RegisterRequest): Response<ApiResponse>

    @POST("Authentication/ConfirmEmail")
    suspend fun userConfirm(@Body request: ConfirmRequest): Response<ApiResponse>

    @POST("Authentication/ReConfirmEmail")
    suspend fun userReConfirm(@Body request: ReConfirmRequest): Response<ApiResponse>
}