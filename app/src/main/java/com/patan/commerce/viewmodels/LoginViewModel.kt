package com.patan.commerce.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.patan.commerce.model.ConfirmRequest
import com.patan.commerce.model.ForgotPasswordRequest
import com.patan.commerce.model.LoginRequest
import com.patan.commerce.model.ReConfirmRequest
import com.patan.commerce.model.RegisterRequest
import com.patan.commerce.model.ResetPasswordRequest
import com.patan.commerce.model.User
import com.patan.commerce.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
    @Inject
    constructor(
        private val apiService: ApiService,
    ) : BaseViewModel() {
        private val userInfos: MutableLiveData<User?> = MutableLiveData()
        val token: MutableLiveData<String?> = MutableLiveData()
        val userId: MutableLiveData<String?> = MutableLiveData()
        val tokenFromReset: MutableLiveData<String?> = MutableLiveData()

        fun login(
            userName: String?,
            password: String?,
        ) {
            val user = LoginRequest(userName, password)
            viewModelScope.launch {
                try {
                    val response = apiService.userLogin(user)
                    if (response.isSuccessful) {
                        token.postValue(response.body()?.data?.token)
                        userId.postValue(response.body()?.data?.userId)
                        handleSuccess(response.body()?.message, response.body()?.isSuccess)
                        userInfos.postValue(response.body()?.data)
                    } else {
                        handleResponseError(response.message())
                    }
                } catch (e: Exception) {
                    handleError(e.message)
                }
            }
        }

        fun register(userRegister: RegisterRequest) {
            viewModelScope.launch {
                try {
                    val response = apiService.userRegister(userRegister)
                    if (response.isSuccessful) {
                        handleSuccess(response.body()?.message, response.body()?.isSuccess)
                        userInfos.postValue(response.body()?.data)
                    } else {
                        handleResponseError(response.message())
                    }
                } catch (e: Exception) {
                    handleError(e.message)
                }
            }
        }

        fun confirmEmail(
            approvedCode: Int?,
            confirmToken: String?,
            userName: String?,
        ) {
            val confirmUser = ConfirmRequest(approvedCode, confirmToken, userName)
            viewModelScope.launch {
                try {
                    val response = apiService.userConfirm(confirmUser)
                    if (response.isSuccessful) {
                        token.postValue(response.body()?.data?.token)
                        handleSuccess(response.body()?.message, response.body()?.isSuccess)
                    } else {
                        handleResponseError(response.message())
                    }
                } catch (e: Exception) {
                    handleError(e.message)
                }
            }
        }

        fun reConfirmEmail(userName: String?) {
            val reConfirmUser = ReConfirmRequest(userName)
            viewModelScope.launch {
                try {
                    val response = apiService.userReConfirm(reConfirmUser)
                    if (response.isSuccessful) {
                        token.postValue(response.body()?.data?.token)
                        handleSuccess(response.body()?.message, response.body()?.isSuccess)
                    } else {
                        handleResponseError(response.message())
                    }
                } catch (e: Exception) {
                    handleError(e.message)
                }
            }
        }

        fun forgotPassword(
            userName: String?,
            email: String?,
        ) {
            val request = ForgotPasswordRequest(userName, email)
            viewModelScope.launch {
                try {
                    val response = apiService.forgotPassword(request)
                    if (response.isSuccessful) {
                        tokenFromReset.postValue(response.body()?.data?.token)
                        handleSuccess(response.body()?.message, response.body()?.isSuccess)
                    } else {
                        handleResponseError(response.message())
                    }
                } catch (e: Exception) {
                    handleError(e.message)
                }
            }
        }

        fun resetPassword(
            approvedCode: Int?,
            token: String?,
            userName: String?,
            password: String?,
            rePassword: String?,
        ) {
            val request = ResetPasswordRequest(approvedCode, token, userName, password, rePassword)
            viewModelScope.launch {
                try {
                    val response = apiService.resetPassword(request)
                    if (response.isSuccessful) {
                        handleSuccess(response.body()?.message, response.isSuccessful)
                    } else {
                        handleResponseError(response.message())
                    }
                } catch (e: Exception) {
                    handleError(e.message)
                }
            }
        }
    }
