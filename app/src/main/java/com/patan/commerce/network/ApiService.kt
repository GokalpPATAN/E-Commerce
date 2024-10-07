package com.patan.commerce.network

import com.patan.commerce.model.ApiResponse
import com.patan.commerce.model.Cities
import com.patan.commerce.model.ConfirmRequest
import com.patan.commerce.model.LoginRequest
import com.patan.commerce.model.ReConfirmRequest
import com.patan.commerce.model.RegisterRequest
import com.patan.commerce.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @POST("Authentication/Login")
    suspend fun userLogin(@Body request: LoginRequest): Response<ApiResponse<User>>

    @POST("Authentication/Register")
    suspend fun userRegister(@Body request: RegisterRequest): Response<ApiResponse<User>>

    @POST("Authentication/ConfirmEmail")
    suspend fun userConfirm(@Body request: ConfirmRequest): Response<ApiResponse<User>>

    @POST("Authentication/ReConfirmEmail")
    suspend fun userReConfirm(@Body request: ReConfirmRequest): Response<ApiResponse<User>>

    @POST("Address/GetCities")
    @Headers("Content-Type: application/json")
    suspend fun getCities(
        @Header("Authorization") token: String?,
        @Body body: Map<String, String> = emptyMap()
    ): Response<ApiResponse<List<Cities>>>

}