package com.uade.marketplace.orders.core.usecase.impl;

import com.uade.marketplace.orders.core.domain.Order;
import com.uade.marketplace.orders.core.domain.dto.OrderDTO;
import com.uade.marketplace.orders.core.usecase.CreateOrderUsecase;
import com.uade.marketplace.orders.core.usecase.SendOrderCreatedMessage;
import com.uade.marketplace.orders.mappers.OrderMapper;
import com.uade.marketplace.orders.repository.OrderRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DefaultCreateOrderUsecase implements CreateOrderUsecase {

  private final OrderRepository orderRepository;
  private final SendOrderCreatedMessage sendOrderCreatedMessage;

  @Override
  public OrderDTO apply(final OrderDTO orderDto) {
    OrderDTO savedOrder = saveOrder(orderDto);
    log.info("Order created {}", savedOrder);
    sendOrderCreatedMessage.accept(savedOrder);
    return savedOrder;
  }

  private OrderDTO saveOrder(OrderDTO orderDto) {
    OrderMapper mapper = OrderMapper.INSTANCE;

    final Order order = mapper.orderDTOToOrder(orderDto).withId(UUID.randomUUID().toString());

    final Order savedOrder = orderRepository.save(order);

    return mapper.orderToOrderDTO(savedOrder);
  }
}
