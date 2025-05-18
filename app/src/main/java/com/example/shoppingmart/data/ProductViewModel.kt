package com.example.shoppingmart.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
class ProductViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _products = MutableLiveData<List<data.Product>>()
    val products: LiveData<List<data.Product>> get() = _products

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    init {
        getProductList()
    }

    fun getProductList() {
        viewModelScope.launch {
            try {
                val response = repository.fetchProducts()
                if (response.isSuccessful) {
                    _products.value = response.body()?.products?.filterNotNull()
                    Log.d("sv",response.body().toString())
                } else {
                    _error.value = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                _error.value = "Exception: ${e.message}"
            }
        }
    }
}
