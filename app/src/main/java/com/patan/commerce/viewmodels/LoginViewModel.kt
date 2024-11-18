package com.patan.commerce.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.patan.commerce.model.ConfirmRequest
import com.patan.commerce.model.LoginRequest
import com.patan.commerce.model.ReConfirmRequest
import com.patan.commerce.model.RegisterRequest
import com.patan.commerce.model.User
import com.patan.commerce.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val apiService: ApiService) :
    BaseViewModel() {

    private val userInfos: MutableLiveData<User?> = MutableLiveData()
    val token: MutableLiveData<String?> = MutableLiveData()
    val userId: MutableLiveData<String?> = MutableLiveData()


    fun login(userName: String?, password: String?) {
        val user = LoginRequest(userName, password)
        viewModelScope.launch {
            try {
                val response = apiService.userLogin(user)
                if (response.isSuccessful) {
                    token.postValue(response.body()?.data?.token)
                    userId.postValue(response.body()?.data?.userId)
                    handleSuccess(response.body()?.message, response.body()?.ısSuccess)
                    userInfos.postValue(response.body()?.data)
                } else {
                    handleResponseError(response.message())
                }
            } catch (e: Exception) {
                handleError(e.message)
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
                    handleSuccess(response.body()?.message, response.body()?.ısSuccess)
                    userInfos.postValue(response.body()?.data)
                } else {
                    handleResponseError(response.message())
                }
            } catch (e: Exception) {
                handleError(e.message)
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
                    handleSuccess(response.body()?.message, response.body()?.ısSuccess)
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
                    handleSuccess(response.body()?.message, response.body()?.ısSuccess)
                } else {
                    handleResponseError(response.message())
                }
            } catch (e: Exception) {
                handleError(e.message)
            }
        }
    }
}
