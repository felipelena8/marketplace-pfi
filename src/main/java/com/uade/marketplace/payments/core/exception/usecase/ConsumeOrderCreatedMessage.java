package com.uade.marketplace.payments.core.exception.usecase;

import com.uade.marketplace.base.core.usecase.ConsumeMessage;
import com.uade.marketplace.payments.core.domain.dto.OrderDTO;
import com.uade.marketplace.payments.core.domain.entity.Order;
import com.uade.marketplace.payments.repository.PaymentsRepository;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ConsumeOrderCreatedMessage implements ConsumeMessage<OrderDTO> {

  private PaymentsRepository paymentsRepository;

  @Override
  public void accept(OrderDTO orderDTO) {

    Order order =
        Order.builder()
            .date(LocalDate.now().toString())
            .totalPrice(orderDTO.getPrice() * orderDTO.getQuantity())
            .email(orderDTO.getEmail())
            .itemId(orderDTO.getItemId())
            .quantity(orderDTO.getQuantity())
            .unitPrice(orderDTO.getPrice())
            .build();

    paymentsRepository.save(order);
  }
}
