package com.patan.commerce.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("UserName") val userName: String?,
    @SerializedName("Password") val password: String?
)

data class ConfirmRequest(
    @SerializedName("ApprovedCode") val approvedCode: Int?,
    @SerializedName("Token") val token: String?,
    @SerializedName("UserName") val userName: String?
)

data class RegisterRequest(
    @SerializedName("Email") val email: String?,
    @SerializedName("Gender") val gender: String?,
    @SerializedName("Name") val name: String?,
    @SerializedName("Password") val password: String?,
    @SerializedName("PhoneNumber") val phoneNumber: String?,
    @SerializedName("RePassword") val rePassword: String?,
    @SerializedName("Surname") val surname: String?,
    @SerializedName("UserName") val userName: String?
)

data class ReConfirmRequest(
    @SerializedName("UserName") val userName: String?
)

data class GetProductByIdRequest(
    @SerializedName("ProductId") val productId: String?,
    @SerializedName("ProductScoreCount") val productScoreCount: String?
)

data class ParentIdRequest(
    @SerializedName("ParentId") val parentId: Int?
)

data class UpdateUserRequest(
    @SerializedName("Email") val email: String?,
    @SerializedName("Gender") val gender: String?,
    @SerializedName("Name") val name: String?,
    @SerializedName("PhoneNumber") val phoneNumber: String?,
    @SerializedName("Surname") val surname: String?,
    @SerializedName("UserName") val userName: String?
)

data class CityIdRequest(
    @SerializedName("CityId") val cityId: Int?,
)

data class AddAddressRequest(
    @SerializedName("AddressName") val adress: String?,
    @SerializedName("ReciverName") val receiverName: String?,
    @SerializedName("ReciverPhone") val receiverPhone: String?,
    @SerializedName("UserId") val userId: String?,
    @SerializedName("CityId") val cityId: Int?,
    @SerializedName("CountyId") val countyId: Int?,
    @SerializedName("Description") val description: String?,
)

data class UpdateAddressRequest(
    @SerializedName("Id") val Id: Int?,
    @SerializedName("Description") val description: String?,
    @SerializedName("CityId") val cityId: Int?,
    @SerializedName("CountyId") val countyId: Int?,
    @SerializedName("AddressName") val adress: String?,
    @SerializedName("ReciverName") val receiverName: String?,
    @SerializedName("ReciverPhone") val receiverPhone: String?,
    @SerializedName("UserId") val userId: String?,
)

data class GetAddressRequest(
    @SerializedName("userId") val userId: String?,
)

data class AddCartRequest(
    @SerializedName("UserId") val userId: String?,
    @SerializedName("ProductId") val productId: Int?,
    @SerializedName("Quantity") val quantity: Int?
)

data class GetCartRequest(
    @SerializedName("UserId") val userId: String?
)