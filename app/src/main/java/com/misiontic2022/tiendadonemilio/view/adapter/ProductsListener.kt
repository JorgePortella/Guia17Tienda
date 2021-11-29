package com.misiontic2022.tiendadonemilio.view.adapter

import com.misiontic2022.tiendadonemilio.model.Products

interface ProductsListener {
    fun OnProductsClick(product: Products, position: Int)
}