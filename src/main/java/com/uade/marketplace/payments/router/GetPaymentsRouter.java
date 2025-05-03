package com.uade.marketplace.payments.router;

import com.uade.marketplace.payments.core.domain.entity.Payment;
import com.uade.marketplace.payments.repository.PaymentsRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GetPaymentsRouter {

  private PaymentsRepository paymentsRepository;

  @GetMapping("/payments")
  public List<Payment> getPayment() {
    return paymentsRepository.findAll();
  }
}
