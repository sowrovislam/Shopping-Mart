package com.example.shoppingmart.data


import retrofit2.Response
class ProductRepository {
    suspend fun fetchProducts(): Response<data> {
        return RetrofitClient.apiService.getProducts()
    }


}
