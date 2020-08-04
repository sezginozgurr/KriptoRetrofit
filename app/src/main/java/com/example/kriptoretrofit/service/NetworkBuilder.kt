package com.example.kriptoretrofit.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Bu class retrofit set ederek geriye instance donduruyor. Ayrica atilan istekleri gormek icin de
 * interceptor var.
 */
class NetworkBuilder {

    private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val instance: CryptoAPI by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(CryptoAPI::class.java)
    }

    companion object {
        private const val BASE_URL = "https://api.nomics.com/v1/"
    }
}