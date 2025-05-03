package com.uade.marketplace.payments.core.domain.entity;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Builder
public class Order {
  private String id;
  private String itemId;
  private int quantity;
  private String email;
  private Double unitPrice;
  private Double totalPrice;
  private String date;
}
