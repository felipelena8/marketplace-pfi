package com.uade.marketplace.orders.router;

import com.uade.marketplace.orders.core.domain.dto.OrderDTO;
import com.uade.marketplace.orders.core.usecase.CreateOrderUsecase;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CreateOrderRouter {

  private final CreateOrderUsecase createOrderUsecase;

  @PostMapping("/orders")
  public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO order) {

    final OrderDTO orderDto = createOrderUsecase.apply(order);
    return ResponseEntity.ok(orderDto);
  }
}
