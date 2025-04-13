package com.uade.marketplace.orders.core.domain.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class OrderDto {
  @With private String orderId;
  private String itemId;
  private int quantity;
}
