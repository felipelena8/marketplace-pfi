package com.uade.marketplace.payments.repository;

import com.uade.marketplace.payments.core.domain.entity.Payment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class DefaultPaymentsRepository implements PaymentsRepository {

  private final List<Payment> payments;

  public DefaultPaymentsRepository() {
    this.payments = new ArrayList<>();

    payments.addAll(
        List.of(
            Payment.builder()
                .date(LocalDateTime.now().minusDays(3).toString())
                .email("nachocesarani@uade.edu.ar")
                .itemId(UUID.randomUUID().toString())
                .totalPrice(1000.0)
                .unitPrice(1000.0)
                .quantity(1)
                .id(UUID.randomUUID().toString())
                .description("TV 4K OLED")
                .build(),
            Payment.builder()
                .date(LocalDateTime.now().minusDays(1).minusMinutes(80).toString())
                .email("alesusmelij@uade.edu.ar")
                .itemId(UUID.randomUUID().toString())
                .totalPrice(500.0)
                .unitPrice(500.0)
                .quantity(1)
                .id(UUID.randomUUID().toString())
                .description("PlayStation 5 pro")
                .build()));
  }

  @Override
  public void save(Payment payment) {
    payments.add(payment);
  }

  @Override
  public List<Payment> findAll() {
    return payments;
  }
}
