package com.patan.commerce.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patan.commerce.model.ApiResponse
import com.patan.commerce.model.ConfirmRequest
import com.patan.commerce.model.Data
import com.patan.commerce.model.LoginRequest
import com.patan.commerce.model.ReConfirmRequest
import com.patan.commerce.model.RegisterRequest
import com.patan.commerce.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
    val userInfos: MutableLiveData<Data?> = MutableLiveData()
    val responseNotifications: MutableLiveData<ApiResponse> = MutableLiveData()
    val errorMessage: MutableLiveData<String?> = MutableLiveData()
    val token: MutableLiveData<String?> = MutableLiveData()

    fun login(userName: String?, password: String?) {
        val user = LoginRequest(userName, password)
        viewModelScope.launch {
            try {
                val response = apiService.userLogin(user)
                if (response.isSuccessful) {
                    token.postValue(response.body()?.data?.token)
                    responseNotifications.postValue(response.body())
                    userInfos.postValue(response.body()?.data)
                } else {
                    errorMessage.value =
                        response.message().takeIf { it.isNotEmpty() } ?: "An unknown error occurred"
                }
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }
    }

    fun register(
        name: String?,
        userName: String?,
        surName: String?,
        gender: String?,
        phoneNumber: String?,
        email: String?,
        password: String?,
        repassword: String?
    ) {
        val registerUser = RegisterRequest(
            email, gender, name, password, phoneNumber, repassword, surName, userName
        )
        viewModelScope.launch {
            try {
                val response = apiService.userRegister(registerUser)
                if (response.isSuccessful) {
                    responseNotifications.postValue(response.body())
                    userInfos.postValue(response.body()?.data)
                } else {
                    errorMessage.value =
                        response.message().takeIf { it.isNotEmpty() } ?: "An unknown error occurred"
                }
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }
    }


    fun confirmEmail(approvedCode: Int?, confirmToken: String?, userName: String?) {
        val confirmUser = ConfirmRequest(approvedCode, confirmToken, userName)
        viewModelScope.launch {
            try {
                val response = apiService.userConfirm(confirmUser)
                if (response.isSuccessful) {
                    token.postValue(response.body()?.data?.token)
                } else {
                    errorMessage.value =
                        response.message().takeIf { it.isNotEmpty() } ?: "An unknown error occurred"
                }
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
            return@launch
        }
    }

    fun reConfirmEmail(userName: String?) {
        val reConfirmUser = ReConfirmRequest(userName)
        viewModelScope.launch {
            try {
                val response = apiService.userReConfirm(reConfirmUser)
                if (response.isSuccessful) {
                    token.postValue(response.body()?.data?.token)
                } else {
                    errorMessage.value =
                        response.message().takeIf { it.isNotEmpty() } ?: "An unknown error occurred"
                }
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }

    }
}