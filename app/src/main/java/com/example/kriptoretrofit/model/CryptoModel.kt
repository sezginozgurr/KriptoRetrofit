package com.example.kriptoretrofit.model

import com.google.gson.annotations.SerializedName


data class CryptoModel(
    @SerializedName("currently")
    val currently: String,

    @SerializedName("price")
    val price: String
) {
}