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

    payments.add(
        Payment.builder()
            .date(LocalDateTime.now().toString())
            .email("joubina@uade.edu.ar")
            .itemId(UUID.randomUUID().toString())
            .totalPrice(1000.0)
            .unitPrice(1000.0)
            .quantity(1)
            .id(UUID.randomUUID().toString())
            .build());
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
