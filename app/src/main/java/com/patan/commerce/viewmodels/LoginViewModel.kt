package com.patan.commerce.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patan.commerce.model.Data
import com.patan.commerce.model.LoginRequest
import com.patan.commerce.model.LoginResponse
import com.patan.commerce.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
    val userInfos: MutableLiveData<Data?> = MutableLiveData()
    val responseNotifications: MutableLiveData<LoginResponse> = MutableLiveData()
    val token: MutableLiveData<String?> = MutableLiveData()
    val errorMessage: MutableLiveData<String?> = MutableLiveData()

    fun login(userName:String?,password:String?) {
        val user = LoginRequest(userName,password)
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
}