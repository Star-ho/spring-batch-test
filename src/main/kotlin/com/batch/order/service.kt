package com.batch.member

import com.batch.member.dto.RegisterOrderRequest
import com.batch.order.Order
import com.batch.order.OrderFactory
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull


@Component
class OrderService(
    private val orderRepository: OrderRepository,
    private val orderFactory: OrderFactory,
) {
    fun getOrders(): List<Order> {
        return orderRepository.findAll()
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun getOrder(id: Long): Order {
        return orderRepository.findById(id).getOrNull() ?: throw IllegalArgumentException("주문을 찾을 수 없습니다")
    }

    fun registerOrder(registerOrderRequest: RegisterOrderRequest) {
        orderFactory.createOrder(registerOrderRequest)
    }
}