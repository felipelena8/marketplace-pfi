package com.uade.marketplace.inventory.core.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@With
public class Item {
  @Id
  private String itemId;
  private String description;
  private Integer quantity;
  private Double price;
}
