package com.uade.marketplace.payments.repository;

import com.uade.marketplace.payments.core.domain.entity.Order;

import java.util.List;

public interface PaymentsRepository {

  void save(Order order);

  List<Order> findAll();
}
