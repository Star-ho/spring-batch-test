package com.batch.member.dto

class RegisterOrderRequest(
    val memberId: Long,
    val products: List<CreateOrderEntryRequest>,
)

class CreateOrderEntryRequest(
    val productId: Long,
    val quantity: Int
)