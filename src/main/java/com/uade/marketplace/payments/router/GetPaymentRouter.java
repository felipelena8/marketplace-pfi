package com.uade.marketplace.payments.router;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPaymentRouter {

    @GetMapping("/payments/{payment_id}")
    public ResponseEntity<String> getPayment(@PathVariable("payment_id") String paymentId) {
        return ResponseEntity.ok().body(paymentId);
    }
}
