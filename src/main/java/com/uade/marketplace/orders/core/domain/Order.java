package com.uade.marketplace.orders.core.domain;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Builder
public class Order {
  @With private String id;
  private String itemId;
  private int quantity;
  private String email;
  private Double unitPrice;
  private Double totalPrice;
  private String date;
}
