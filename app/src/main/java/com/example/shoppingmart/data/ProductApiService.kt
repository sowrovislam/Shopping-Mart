package com.example.shoppingmart.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.Response

interface ProductApiService {
    @GET("products")
    suspend fun getProducts():Response<data>
}

object RetrofitClient {
    private const val BASE_URL = "https://dummyjson.com/"

    val apiService: ProductApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApiService::class.java)
    }
}

