package com.uade.marketplace.payments.core.domain.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class OrderDTO {
  @With private String id;
  private String itemId;
  private int quantity;
  private String email;
  private Double price;
  private String description;
}
