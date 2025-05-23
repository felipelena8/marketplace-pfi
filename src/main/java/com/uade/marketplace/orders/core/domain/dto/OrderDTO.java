package com.uade.marketplace.orders.core.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class OrderDTO {
  @With private String id;
  @JsonProperty("item_id")
  private String itemId;
  private int quantity;
  private String email;
  private Double price;
  private String description;
}
