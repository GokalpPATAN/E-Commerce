package com.patan.commerce.repositories

import com.patan.commerce.model.AddAddressRequest
import com.patan.commerce.model.Addresses
import com.patan.commerce.model.Cities
import com.patan.commerce.model.CityIdRequest
import com.patan.commerce.model.GetAddressRequest
import com.patan.commerce.model.UpdateAddressRequest
import com.patan.commerce.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class AddressRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCities(token: String?): Flow<List<Cities?>> =
        flow {
            val response = apiService.getCities(token)
            if (response.isSuccessful) {
                emit(response.body()?.data ?: emptyList())
            }
        }

    suspend fun getDistrict(token: String?, cityId: CityIdRequest): Flow<List<Cities?>> = flow {
        val response = apiService.getDistrict(token, cityId)
        if (response.isSuccessful) {
            emit(response.body()?.data ?: emptyList())
        } else {
            emit(emptyList())
        }
    }

    suspend fun addAddress(token: String?, address: AddAddressRequest) =
        apiService.addAddress(token, address)

    fun getAddresses(token: String?, userId: GetAddressRequest): Flow<List<Addresses?>> = flow {
        val response = apiService.getAddress(token, userId)
        if (response.isSuccessful) {
            emit(response.body()?.data ?: emptyList())
        } else {
            emit(emptyList())
        }
    }

    suspend fun updateAddress(token: String?, address: UpdateAddressRequest) =
        apiService.updateAddress(token, address)
}
