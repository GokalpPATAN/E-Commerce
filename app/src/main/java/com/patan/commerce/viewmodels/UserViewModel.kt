package com.patan.commerce.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.patan.commerce.di.TokenQualifier
import com.patan.commerce.di.UserIdQualifier
import com.patan.commerce.model.AddPaymentRequest
import com.patan.commerce.model.DeleteCartRequest
import com.patan.commerce.model.GetCartRequest
import com.patan.commerce.model.PaymentCardResponses
import com.patan.commerce.model.SaveOrderRequest
import com.patan.commerce.model.UpdateUserRequest
import com.patan.commerce.model.User
import com.patan.commerce.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel
    @Inject
    constructor(
        private val repository: UserRepository,
        @TokenQualifier private val token: String?,
        @UserIdQualifier private val userId: String?,
    ) : BaseViewModel() {
        private val userInfos: MutableLiveData<User?> = MutableLiveData()
        val _userInfos get() = userInfos

        private val cardList: MutableLiveData<PaymentCardResponses> = MutableLiveData()
        val _cardList get() = cardList

        fun getUserInfos() {
            viewModelScope.launch {
                try {
                    userInfos.postValue(repository.getUserInfos(token))
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
            userName: String?,
        ) {
            viewModelScope.launch {
                val userInfos = UpdateUserRequest(email, gender, name, phoneNumber, surname, userName)
                try {
                    repository.updateUser(token, userInfos)
                } catch (e: Exception) {
                    handleError(e.message)
                }
            }
        }

        fun addPaymentCard(
            cardName: String?,
            cardNumber: String?,
            finishMonth: Int?,
            finishYear: Int?,
            cvv: String?,
            ownerName: String?,
            userId: String?,
        ) {
            viewModelScope.launch {
                val paymentCard =
                    AddPaymentRequest(
                        cardName,
                        cardNumber,
                        finishMonth,
                        finishYear,
                        cvv,
                        ownerName,
                        userId,
                    )
                try {
                    repository.addPaymentMethod(token, paymentCard)
                } catch (e: Exception) {
                    handleError(e.message)
                }
            }
        }

        fun getPaymentCards(userId: String?) {
            viewModelScope.launch {
                val getPaymentCards = GetCartRequest(userId)
                try {
                    cardList.postValue(repository.getPaymentCards(token, getPaymentCards))
                } catch (e: Exception) {
                    handleError(e.message)
                }
            }
        }

        fun deleteCard(id: String?) {
            viewModelScope.launch {
                val request = DeleteCartRequest(id)
                try {
                    repository.deletePaymentCard(token, request)
                } catch (e: Exception) {
                    handleError(e.message)
                }
            }
        }

        fun saveOrder(orders: SaveOrderRequest) {
            viewModelScope.launch {
                try {
                    repository.saveOrder(token, orders)
                    println("Order saved successfully")
                } catch (e: Exception) {
                    handleError(e.message)
                }
            }
        }
    }
