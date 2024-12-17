package com.patan.commerce.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    protected val isSuccess: MutableLiveData<Boolean?> = MutableLiveData()
    val success get() = isSuccess

    protected val errorMessage: MutableLiveData<String?> = MutableLiveData()
    val error get() = errorMessage

    protected val responseNotifications: MutableLiveData<String?> = MutableLiveData()
    val notifications get() = responseNotifications

    protected fun handleSuccess(
        message: Any?,
        success: Boolean?,
    ) {
        responseNotifications.postValue(message.toString())
        isSuccess.postValue(success)
    }

    protected fun handleError(error: String?) {
        errorMessage.postValue(error ?: "An unknown error occurred")
    }

    protected fun handleResponseError(message: String?) {
        errorMessage.postValue(message ?: "An unknown error occurred")
    }
}
