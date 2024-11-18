package com.patan.commerce.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("Email") val email: String?,
    @SerializedName("Name") val name: String?,
    @SerializedName("PhoneNumber") val phoneNumber: String?,
    @SerializedName("Surname") val surname: String?,
    @SerializedName("Token") val token: String?,
    @SerializedName("Gender") val gender: String?,
    @SerializedName("Password") val password: String?,
    @SerializedName("RePassword") val rePassword: String?,
    @SerializedName("UserName") val userName: String?,
    @SerializedName("UserId") val userId: String?,
)

data class Cities(
    @SerializedName("Id") val Id: Int?,
    @SerializedName("Name") val name: String?,
)

data class Products(
    @SerializedName("Name")
    val name: String?,
    @SerializedName("Price")
    val price: Int?,
    @SerializedName("Score")
    val score: Double?,
    @SerializedName("ScoreCount")
    val scoreCount: Int?,
    @SerializedName("SubCategoryId")
    val subCategoryId: Int?,
    @SerializedName("TradeMark")
    val tradeMark: String?,
    @SerializedName("Id")
    val ıd: Int?,
    @SerializedName("Images")
    val ımages: List<Any?>?,
    @SerializedName("Information")
    val ınformation: Any?,
    @SerializedName("IsStocksOut")
    val ısStocksOut: Boolean?
)

data class HighestCategory(
    @SerializedName("TopCategoryId")
    val topCategoryId: Int?,
    @SerializedName("CategoryId")
    val CategoryId: Int?,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("Description")
    val description: String?,
    @SerializedName("Image")
    val image: String?
)

data class CategoriesByParentId(
    @SerializedName("CategoryId")
    val CategoryId: Int?,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("Description")
    val description: String?,
    @SerializedName("Image")
    val image: String?
)

data class Addresses(
    @SerializedName("Id")
    val id: Int?,
    @SerializedName("CityName")
    val cityName: String?,
    @SerializedName("CountyName")
    val countyName: String?,
    @SerializedName("Description")
    val description: String?,
    @SerializedName("AddressName")
    val addressName: String?,
    @SerializedName("ReciverName")
    val receiverName: String?,
    @SerializedName("ReciverPhone")
    val receiverPhone: String?
)

data class ProductsByCategoryRequest(
    @SerializedName("CategoryId")
    val CategoryId: Int?,
    @SerializedName("PageNumber")
    val PageNumber: Int?,
    @SerializedName("ProductCount")
    val ProductCount: Int?,
    @SerializedName("Options")
    val Options: Int?
)

data class CartData(
    @SerializedName("CardId") val cardId: Int?,
    @SerializedName("CardItems") val cardItems: List<CardItem>?
)

data class CardItem(
    @SerializedName("CardItemId") val cardItemId: Int?,
    @SerializedName("ProductId") val productId: Int?,
    @SerializedName("ProductName") val productName: String?,
    @SerializedName("Price") val price: Int?,
    @SerializedName("Quantity") val quantity: Int?,
    @SerializedName("Images") val images: List<String>?
)
