package com.uade.marketplace.inventory.router;

import com.uade.marketplace.inventory.core.domain.entity.Item;
import com.uade.marketplace.inventory.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GetItemRouter {

  private final ItemRepository itemRepository;

  @GetMapping("/items/{item_id}")
  public Item getPayment(@PathVariable("item_id") String itemId) {
    return itemRepository.findById(itemId);
  }
}
