package com.uade.marketplace.inventory.repository;

import com.uade.marketplace.inventory.core.domain.entity.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class DefaultItemRepository implements ItemRepository {

  private Map<String, Item> items;

  public DefaultItemRepository() {
    items = new HashMap<>(); // Use a mutable map
    Item item1 = createItem("MacBook", 10, 999.99);
    Item item2 = createItem("Smartwatch", 20, 200.5);
    Item item3 = createItem("Samsung S24 Ultra", 5, 1200.0);

    items.put(item1.getItemId(), item1);
    items.put(item2.getItemId(), item2);
    items.put(item3.getItemId(), item3);
  }

  @Override
  public List<Item> findAll() {
    return new ArrayList<>(items.values());
  }

  @Override
  public Item save(Item item) {
    return items.put(item.getItemId(), item);
  }

  @Override
  public Item findById(String id) {
    return items.get(id);
  }

  private Item createItem(String description, Integer quantity, Double price) {
    return Item.builder()
        .description(description)
        .quantity(quantity)
        .price(price)
        .itemId(UUID.randomUUID().toString())
        .build();
  }
}
