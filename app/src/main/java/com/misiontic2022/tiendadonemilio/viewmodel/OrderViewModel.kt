package com.misiontic2022.tiendadonemilio.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.misiontic2022.tiendadonemilio.model.Products
import com.misiontic2022.tiendadonemilio.network.Callback
import com.misiontic2022.tiendadonemilio.network.FirestoreService
import java.lang.Exception

class OrderViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listProducts : MutableLiveData<List<Products>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getProductsFromFrirebase()
    }

    fun getProductsFromFrirebase(){
        firestoreService.getProducts(object : Callback<List<Products>> {
            override fun onSuccess(result: List<Products>?) {
                listProducts.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished() {
        isLoading.value = true
    }
}