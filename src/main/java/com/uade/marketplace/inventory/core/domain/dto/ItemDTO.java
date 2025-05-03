package com.uade.marketplace.inventory.core.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
  private String itemId;
  private Integer quantity;
  private Double price;
}
