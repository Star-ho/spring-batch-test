package com.batch.member

import com.batch.order.Order
import com.batch.order.OrderEntry
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long>

@Repository
interface OrderEntryRepository : JpaRepository<OrderEntry, Long>