package com.patan.commerce.repositories

import com.patan.commerce.model.AddPaymentRequest
import com.patan.commerce.model.CartData
import com.patan.commerce.model.DeleteCartRequest
import com.patan.commerce.model.GetCartRequest
import com.patan.commerce.model.PaymentCardResponses
import com.patan.commerce.model.SaveOrderRequest
import com.patan.commerce.model.UpdateUserRequest
import com.patan.commerce.model.User
import com.patan.commerce.network.ApiService
import javax.inject.Inject

class UserRepository
    @Inject
    constructor(
        private val apiService: ApiService,
    ) {
        suspend fun addPaymentMethod(
            token: String?,
            paymentRequest: AddPaymentRequest,
        ) = apiService.addPaymentCard(token, paymentRequest)

        suspend fun getUserInfos(token: String?): User? {
            val response = apiService.getUserInfos(token)

            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception("Failed to fetch categories: ${response.message()}")
            }
        }

        suspend fun updateUser(
            token: String?,
            request: UpdateUserRequest,
        ): User? {
            val response =
                apiService.updateUser(
                    token,
                    request,
                )
            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception("Failed to fetch categories: ${response.message()}")
            }
        }

        suspend fun getPaymentCards(
            token: String?,
            request: GetCartRequest,
        ): PaymentCardResponses? {
            val response = apiService.getPaymentCards(token, request)
            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception("Failed to fetch categories: ${response.message()}")
            }
        }

        suspend fun deletePaymentCard(
            token: String?,
            request: DeleteCartRequest,
        ): CartData? {
            val response = apiService.deletePaymentCard(token, request)
            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception("Failed to fetch categories: ${response.message()}")
            }
        }

        suspend fun saveOrder(
            token: String?,
            request: SaveOrderRequest,
        ): CartData? {
            val response = apiService.saveOrder(token, request)
            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception("Failed to fetch categories: ${response.message()}")
            }
        }
    }
