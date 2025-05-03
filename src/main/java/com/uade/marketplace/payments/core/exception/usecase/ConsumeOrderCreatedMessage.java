package com.uade.marketplace.payments.core.exception.usecase;

import com.uade.marketplace.base.core.usecase.ConsumeMessage;
import com.uade.marketplace.payments.core.domain.dto.OrderDTO;
import com.uade.marketplace.payments.core.domain.entity.Payment;
import com.uade.marketplace.payments.repository.PaymentsRepository;
import java.time.LocalDateTime;
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

    Payment payment =
        Payment.builder()
            .date(LocalDateTime.now().toString())
            .totalPrice(orderDTO.getPrice() * orderDTO.getQuantity())
            .email(orderDTO.getEmail())
            .itemId(orderDTO.getItemId())
            .quantity(orderDTO.getQuantity())
            .unitPrice(orderDTO.getPrice())
            .description(orderDTO.getDescription())
            .build();

    paymentsRepository.save(payment);
  }
}
