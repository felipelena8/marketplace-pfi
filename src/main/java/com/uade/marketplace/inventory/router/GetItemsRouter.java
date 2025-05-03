package com.uade.marketplace.inventory.router;

import com.uade.marketplace.inventory.core.domain.entity.Item;
import com.uade.marketplace.inventory.repository.ItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GetItemsRouter {

  private final ItemRepository itemRepository;

  @GetMapping("/items")
  public List<Item> getPayment() {
    return itemRepository.findAll();
  }
}
