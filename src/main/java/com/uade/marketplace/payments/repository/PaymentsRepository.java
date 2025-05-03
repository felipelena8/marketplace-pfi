package com.uade.marketplace.payments.repository;

import com.uade.marketplace.payments.core.domain.entity.Payment;

import java.util.List;

public interface PaymentsRepository {

  void save(Payment payment);

  List<Payment> findAll();
}
