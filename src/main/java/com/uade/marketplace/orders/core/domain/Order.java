package com.uade.marketplace.orders.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.With;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@ToString
@Table(name = "\"Order\"") // Escaping the table name
public class Order {
  @With @Id private String id;
  private String itemId;
  private int quantity;
}
