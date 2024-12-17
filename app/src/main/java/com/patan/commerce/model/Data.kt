package com.patan.commerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

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
    @SerializedName("Id") val id: Int?,
    @SerializedName("Name") val name: String?,
)

data class Products(
    @SerializedName("Name") val name: String?,
    @SerializedName("Price") val price: Int?,
    @SerializedName("Score") val score: Double?,
    @SerializedName("ScoreCount") val scoreCount: Int?,
    @SerializedName("SubCategoryId") val subCategoryId: Int?,
    @SerializedName("TradeMark") val tradeMark: String?,
    @SerializedName("Id") val id: Int?,
    @SerializedName("Images") val images: List<Any?>?,
    @SerializedName("Information") val information: Any?,
    @SerializedName("IsStocksOut") val isStocksOut: Boolean?,
)

data class HighestCategory(
    @SerializedName("TopCategoryId") val topCategoryId: Int?,
    @SerializedName("CategoryId") val categoryId: Int?,
    @SerializedName("Name") val name: String?,
    @SerializedName("Description") val description: String?,
    @SerializedName("Image") val image: String?,
)

data class CategoriesByParentId(
    @SerializedName("CategoryId") val categoryId: Int?,
    @SerializedName("Name") val name: String?,
    @SerializedName("Description") val description: String?,
    @SerializedName("Image") val image: String?,
)

data class Addresses(
    @SerializedName("Id") val id: Int?,
    @SerializedName("CityName") val cityName: String?,
    @SerializedName("CountyName") val countyName: String?,
    @SerializedName("Description") val description: String?,
    @SerializedName("AddressName") val addressName: String?,
    @SerializedName("ReciverName") val receiverName: String?,
    @SerializedName("ReciverPhone") val receiverPhone: String?,
)

data class ProductsByCategoryRequest(
    @SerializedName("CategoryId") val categoryId: Int?,
    @SerializedName("PageNumber") val pageNumber: Int?,
    @SerializedName("ProductCount") val productCount: Int?,
    @SerializedName("Options") val options: Int?,
)

data class CartData(
    @SerializedName("CardId") val cardId: Int?,
    @SerializedName("CardItems") val cardItems: List<CardItem>?,
)

data class CardItem(
    @SerializedName("CardItemId") val cardItemId: Int?,
    @SerializedName("ProductId") val productId: Int?,
    @SerializedName("ProductName") val productName: String?,
    @SerializedName("Price") val price: Int?,
    @SerializedName("Quantity") val quantity: Int?,
    @SerializedName("Images") val images: List<String>?,
)

@Parcelize
data class CardItems(
    @SerializedName("CardItemId") val cardItemId: Int?,
) : Parcelable

data class AddressesInputs(
    val addressId: Int?,
    val addressName: String?,
    val receiverName: String?,
    val receiverPhone: String?,
    val userId: String?,
    val cityId: Int?,
    val countyId: Int?,
    val description: String?,
)

data class GetComment(
    @SerializedName("Id") val productId: Int?,
    @SerializedName("Score") val score: Int?,
    @SerializedName("Command") val comment: String?,
)

data class GetPaymentCards(
    @SerializedName("CardName") val cardName: String?,
    @SerializedName("CardNumber") val cardNumber: String?,
    @SerializedName("FinishMonth") val finishMonth: Int?,
    @SerializedName("FinishYear") val finishYear: Int?,
    @SerializedName("CVV") val cvv: String?,
    @SerializedName("OwnerName") val ownerName: String?,
    @SerializedName("Id") val id: String?,
)

data class PaymentCardResponses(
    @SerializedName("PaymentCardResponses") val paymentCards: List<GetPaymentCards>?,
)

@Parcelize
data class ItemList(
    val items: List<CardItems?>,
) : Parcelable
