package com.batch.product.response

import com.batch.product.Product

class ProductResponse(product: Product) {
    val id = product.id
    val label = product.label
    val price = product.price
}