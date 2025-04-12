package com.uade.marketplace.orders.router;

import com.uade.marketplace.orders.core.domain.dto.OrderDto;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateOrderRouter {

  @PostMapping("/orders")
  public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto order) {

    return ResponseEntity.ok(order.withOrderId(UUID.randomUUID().toString()));
  }
}
