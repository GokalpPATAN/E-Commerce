package com.patan.commerce.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patan.commerce.di.TokenQualifier
import com.patan.commerce.model.AddAddressRequest
import com.patan.commerce.model.Addresses
import com.patan.commerce.model.Cities
import com.patan.commerce.model.CityIdRequest
import com.patan.commerce.model.DeleteAddressRequest
import com.patan.commerce.model.GetAddressRequest
import com.patan.commerce.model.UpdateAddressRequest
import com.patan.commerce.repositories.AddressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddressViewModel
    @Inject
    constructor(
        private val repository: AddressRepository,
        @TokenQualifier private val token: String?,
    ) : ViewModel() {
        private val _citiesList = MutableStateFlow<List<Cities?>>(emptyList())
        val citiesList: StateFlow<List<Cities?>> = _citiesList

        private val _addressesList = MutableStateFlow<List<Addresses?>>(emptyList())
        val addressesList: StateFlow<List<Addresses?>> = _addressesList

        fun getCities() {
            viewModelScope.launch {
                repository
                    .getCities(token)
                    .catch { e -> e.printStackTrace() }
                    .collect { _citiesList.value = it }
            }
        }

        fun getDistrict(cityId: Int?) {
            viewModelScope.launch {
                repository
                    .getDistrict(token, CityIdRequest(cityId))
                    .catch { e -> e.printStackTrace() }
                    .collect { _citiesList.value = it }
            }
        }

        fun addAddress(address: AddAddressRequest) {
            viewModelScope.launch {
                try {
                    repository.addAddress(token, address)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        fun getAddresses(userId: String?) {
            viewModelScope.launch {
                repository
                    .getAddresses(token, GetAddressRequest(userId))
                    .catch { e -> e.printStackTrace() }
                    .collect { addresses -> _addressesList.value = addresses }
            }
        }

        fun updateAddress(address: UpdateAddressRequest) {
            viewModelScope.launch {
                try {
                    repository.updateAddress(token, address)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        fun deleteAddress(addressesId: Int?) {
            viewModelScope.launch {
                val addressRequest = DeleteAddressRequest(addressesId)
                try {
                    repository.deleteAddress(token, addressRequest)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
