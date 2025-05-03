package com.uade.marketplace.payments.router;

import com.uade.marketplace.payments.core.domain.entity.Order;
import com.uade.marketplace.payments.repository.PaymentsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetPaymentsRouter {

  private PaymentsRepository paymentsRepository;

  @GetMapping("/payments")
  public List<Order> getPayment() {
    return paymentsRepository.findAll();
  }
}
