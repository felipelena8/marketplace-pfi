package com.uade.marketplace.orders.core.usecase.impl;

import com.uade.marketplace.orders.core.domain.dto.OrderDTO;
import com.uade.marketplace.orders.core.usecase.CreateOrderUsecase;
import com.uade.marketplace.orders.core.usecase.SendOrderCreatedMessage;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DefaultCreateOrderUsecase implements CreateOrderUsecase {

  private final SendOrderCreatedMessage sendOrderCreatedMessage;

  @Override
  public OrderDTO apply(final OrderDTO orderDto) {
    OrderDTO order = orderDto.withId(UUID.randomUUID().toString());
    sendOrderCreatedMessage.accept(order);
    return order;
  }
}
