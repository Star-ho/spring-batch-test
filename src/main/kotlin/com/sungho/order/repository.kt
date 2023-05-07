package com.sungho.member

import com.sungho.order.Order
import com.sungho.order.OrderEntry
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long>

@Repository
interface OrderEntryRepository : JpaRepository<OrderEntry, Long>