package com.uade.marketplace.orders.repository;

import com.uade.marketplace.orders.core.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {}
