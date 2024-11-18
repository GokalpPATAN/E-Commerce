package com.patan.commerce.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.patan.commerce.di.TokenQualifier
import com.patan.commerce.model.UpdateUserRequest
import com.patan.commerce.model.User
import com.patan.commerce.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val apiService: ApiService, @TokenQualifier private val token: String?
) : BaseViewModel() {
    private val userInfos: MutableLiveData<User?> = MutableLiveData()
    val _userInfos get() = userInfos

    fun getUserInfos() {
        viewModelScope.launch {
            val response = apiService.getUserInfos(token)
            try {
                if (response.isSuccessful) {
                    userInfos.postValue(response.body()?.data)
                    handleSuccess(response.body()?.message, response.body()?.ısSuccess)
                } else {
                    handleResponseError(response.message())
                }
            } catch (e: Exception) {
                handleError(e.message)
            }
        }
    }

    fun updateUser(
        email: String?,
        gender: String?,
        name: String?,
        phoneNumber: String?,
        surname: String?,
        userName: String?
    ) {
        viewModelScope.launch {
            val userInfos = UpdateUserRequest(email, gender, name, phoneNumber, surname, userName)
            try {
                val response = apiService.updateUser(token, userInfos)
                if (response.isSuccessful) {
                    handleSuccess(response.message(), response.isSuccessful)
                } else {
                    handleResponseError(response.message())
                }
            } catch (e: Exception) {
                handleError(e.message)

            }

        }
    }
}