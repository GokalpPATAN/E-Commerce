package com.patan.commerce.network

import com.patan.commerce.model.AddAddressRequest
import com.patan.commerce.model.AddCartRequest
import com.patan.commerce.model.AddFavoriteRequest
import com.patan.commerce.model.AddPaymentRequest
import com.patan.commerce.model.AddScoreRequest
import com.patan.commerce.model.Addresses
import com.patan.commerce.model.ApiResponse
import com.patan.commerce.model.CartData
import com.patan.commerce.model.Cities
import com.patan.commerce.model.CityIdRequest
import com.patan.commerce.model.ConfirmRequest
import com.patan.commerce.model.DeleteAddressRequest
import com.patan.commerce.model.DeleteCardItemRequest
import com.patan.commerce.model.DeleteCartRequest
import com.patan.commerce.model.ForgotPasswordRequest
import com.patan.commerce.model.GetAddressRequest
import com.patan.commerce.model.GetCartRequest
import com.patan.commerce.model.GetComment
import com.patan.commerce.model.GetCommentRequest
import com.patan.commerce.model.GetProductByIdRequest
import com.patan.commerce.model.HighestCategory
import com.patan.commerce.model.LoginRequest
import com.patan.commerce.model.ParentIdRequest
import com.patan.commerce.model.PaymentCardResponses
import com.patan.commerce.model.Products
import com.patan.commerce.model.ProductsByCategoryRequest
import com.patan.commerce.model.ReConfirmRequest
import com.patan.commerce.model.RegisterRequest
import com.patan.commerce.model.ResetPasswordRequest
import com.patan.commerce.model.SaveOrderRequest
import com.patan.commerce.model.UpdateAddressRequest
import com.patan.commerce.model.UpdateUserRequest
import com.patan.commerce.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @POST("Authentication/Login")
    suspend fun userLogin(
        @Body request: LoginRequest,
    ): Response<ApiResponse<User>>

    @POST("Authentication/Register")
    suspend fun userRegister(
        @Body request: RegisterRequest,
    ): Response<ApiResponse<User>>

    @POST("Authentication/ConfirmEmail")
    suspend fun userConfirm(
        @Body request: ConfirmRequest,
    ): Response<ApiResponse<User>>

    @POST("Authentication/ReConfirmEmail")
    suspend fun userReConfirm(
        @Body request: ReConfirmRequest,
    ): Response<ApiResponse<User>>

    @GET("Authentication/GetUserInformation")
    suspend fun getUserInfos(
        @Header("Authorization") token: String?,
    ): Response<ApiResponse<User>>

    @GET("Authentication/ForgotPassword")
    suspend fun forgotPassword(
        @Body request: ForgotPasswordRequest,
    ): Response<ApiResponse<User>>

    @GET("Authentication/ResetPassword")
    suspend fun resetPassword(
        @Body request: ResetPasswordRequest,
    ): Response<ApiResponse<User>>

    @POST("Authentication/UpdateUser")
    @Headers("Content-Type: application/json")
    suspend fun updateUser(
        @Header("Authorization") token: String?,
        @Body request: UpdateUserRequest,
    ): Response<ApiResponse<User>>

    @POST("Product/GetProductsByIsHomePage")
    @Headers("Content-Type: application/json")
    suspend fun getProducts(
        @Header("Authorization") token: String?,
        @Body body: Map<String, String> = emptyMap(),
    ): Response<ApiResponse<List<Products>>>

    @POST("Product/GetProductById")
    @Headers("Content-Type: application/json")
    suspend fun getProductDetails(
        @Header("Authorization") token: String?,
        @Body request: GetProductByIdRequest,
    ): Response<ApiResponse<Products>>

    @POST("Category/GetTopCategories")
    @Headers("Content-Type: application/json")
    suspend fun getCategories(
        @Header("Authorization") token: String?,
        @Body body: Map<String, String> = emptyMap(),
    ): Response<ApiResponse<List<HighestCategory>>>

    @POST("Category/GetCategoriesByParentId")
    @Headers("Content-Type: application/json")
    suspend fun getTopCategories(
        @Header("Authorization") token: String?,
        @Body request: ParentIdRequest,
    ): Response<ApiResponse<List<HighestCategory>>>

    @POST("Address/GetCities")
    @Headers("Content-Type: application/json")
    suspend fun getCities(
        @Header("Authorization") token: String?,
        @Body body: Map<String, String> = emptyMap(),
    ): Response<ApiResponse<List<Cities>>>

    @POST("Address/GetCountyByCityId")
    @Headers("Content-Type: application/json")
    suspend fun getDistrict(
        @Header("Authorization") token: String?,
        @Body request: CityIdRequest,
    ): Response<ApiResponse<List<Cities>>>

    @POST("Address/AddAddress")
    @Headers("Content-Type: application/json")
    suspend fun addAddress(
        @Header("Authorization") token: String?,
        @Body request: AddAddressRequest,
    ): Response<ApiResponse<List<Cities>>>

    @POST("Address/GetAddress")
    @Headers("Content-Type: application/json")
    suspend fun getAddress(
        @Header("Authorization") token: String?,
        @Body request: GetAddressRequest,
    ): Response<ApiResponse<List<Addresses>>>

    @POST("Address/UpdateAddress")
    @Headers("Content-Type: application/json")
    suspend fun updateAddress(
        @Header("Authorization") token: String?,
        @Body request: UpdateAddressRequest,
    ): Response<ApiResponse<Addresses>>

    @POST("Product/GetProductsByCategoryId")
    @Headers("Content-Type: application/json")
    suspend fun getProductsByCategory(
        @Header("Authorization") token: String?,
        @Body request: ProductsByCategoryRequest,
    ): Response<ApiResponse<List<Products>>>

    @POST("Cart/AddToCart")
    @Headers("Content-Type: application/json")
    suspend fun addToCart(
        @Header("Authorization") token: String?,
        @Body request: AddCartRequest,
    ): Response<ApiResponse<List<Cities>>>

    @POST("Cart/GetCart")
    @Headers("Content-Type: application/json")
    suspend fun getCart(
        @Header("Authorization") token: String?,
        @Body request: GetCartRequest,
    ): Response<ApiResponse<CartData>>

    @POST("Cart/DeleteToCartItem")
    @Headers("Content-Type: application/json")
    suspend fun deleteFromCart(
        @Header("Authorization") token: String?,
        @Body request: DeleteCardItemRequest,
    ): Response<ApiResponse<CartData>>

    @POST("Cart/ClearToCart")
    @Headers("Content-Type: application/json")
    suspend fun clearCart(
        @Header("Authorization") token: String?,
        @Body request: GetCartRequest,
    ): Response<ApiResponse<CartData>>

    @POST("UserFavoriteProduct/AddUserFavoriteProduct")
    @Headers("Content-Type: application/json")
    suspend fun addFavourite(
        @Header("Authorization") token: String?,
        @Body request: AddFavoriteRequest,
    ): Response<ApiResponse<CartData>>

    @POST("UserFavoriteProduct/DeleteUserFavoriteProduct")
    @Headers("Content-Type: application/json")
    suspend fun deleteFavourite(
        @Header("Authorization") token: String?,
        @Body request: AddFavoriteRequest,
    ): Response<ApiResponse<CartData>>

    @POST("UserFavoriteProduct/GetUserFavoriteProductsByUserId")
    @Headers("Content-Type: application/json")
    suspend fun getFavourite(
        @Header("Authorization") token: String?,
        @Body request: GetAddressRequest,
    ): Response<ApiResponse<List<Products>>>

    @POST("Address/DeleteAddress")
    @Headers("Content-Type: application/json")
    suspend fun deleteAddress(
        @Header("Authorization") token: String?,
        @Body request: DeleteAddressRequest,
    ): Response<ApiResponse<CartData>>

    @POST("ProductScore/AddProductScore")
    @Headers("Content-Type: application/json")
    suspend fun addScore(
        @Header("Authorization") token: String?,
        @Body request: AddScoreRequest,
    ): Response<ApiResponse<CartData>>

    @POST("ProductScore/GetProductScorsByProductId")
    @Headers("Content-Type: application/json")
    suspend fun getScore(
        @Header("Authorization") token: String?,
        @Body request: GetCommentRequest,
    ): Response<ApiResponse<List<GetComment>>>

    @POST("PaymentCard/AddPaymentCard")
    @Headers("Content-Type: application/json")
    suspend fun addPaymentCard(
        @Header("Authorization") token: String?,
        @Body request: AddPaymentRequest,
    ): Response<ApiResponse<List<CartData>>>

    @POST("PaymentCard/GetAllPaymentCards")
    @Headers("Content-Type: application/json")
    suspend fun getPaymentCards(
        @Header("Authorization") token: String?,
        @Body request: GetCartRequest,
    ): Response<ApiResponse<PaymentCardResponses>>

    @POST("PaymentCard/DeletePaymentCard")
    @Headers("Content-Type: application/json")
    suspend fun deletePaymentCard(
        @Header("Authorization") token: String?,
        @Body request: DeleteCartRequest,
    ): Response<ApiResponse<CartData>>

    @POST("Order/SaveOrder")
    @Headers("Content-Type: application/json")
    suspend fun saveOrder(
        @Header("Authorization") token: String?,
        @Body request: SaveOrderRequest,
    ): Response<ApiResponse<CartData>>
}
