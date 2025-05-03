package com.uade.marketplace.payments.repository;

import com.uade.marketplace.payments.core.domain.entity.Order;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DefaultPaymentsRepository implements PaymentsRepository {

  private final List<Order> orders;

  public DefaultPaymentsRepository() {
    this.orders = new ArrayList<>();
  }

  @Override
  public void save(Order order) {
    orders.add(order);
  }

  @Override
  public List<Order> findAll() {
    return orders;
  }
}
