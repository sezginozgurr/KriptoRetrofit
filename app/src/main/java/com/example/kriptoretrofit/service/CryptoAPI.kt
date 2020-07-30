package com.example.kriptoretrofit.service

import com.example.kriptoretrofit.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET


interface CryptoAPI {
    // Get, post , update , delete
    @GET("prices?key=5babfaef5f80a1ab96753e670b81b8da")
    fun getData(): Call<List<CryptoModel>>
}
