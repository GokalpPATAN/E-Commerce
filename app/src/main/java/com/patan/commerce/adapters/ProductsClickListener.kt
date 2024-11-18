package com.patan.commerce.adapters

interface ProductsClickListener {
    fun onProductClicked(productId: Int?, productScoreCount: Int?)
}

interface CategoryClickListener {
    fun onCategoryClicked(topCategoryId: Int?)
}

interface CitiesClickListener {
    fun onCitiesClicked(citiesId: Int?, city: String?)
}

interface AddressClickListener {
    fun onAddressClicked(addressId: Int?)
    fun onAddressUpdated(
        addressId: Int?,
        cityName: String?,
        countyName: String?,
        description: String?,
        addressName: String?,
        receiverName: String?,
        receiverPhone: String?
    )
}
