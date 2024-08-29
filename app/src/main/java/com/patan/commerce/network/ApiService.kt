package com.patan.commerce.network

import com.patan.commerce.model.LoginRequest
import com.patan.commerce.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("Authentication/Login")
    suspend fun userLogin(@Body request: LoginRequest): Response<LoginResponse>
}