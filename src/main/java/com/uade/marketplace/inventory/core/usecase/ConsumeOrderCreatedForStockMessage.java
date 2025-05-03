package com.uade.marketplace.inventory.core.usecase;

import com.uade.marketplace.base.core.usecase.ConsumeMessage;
import com.uade.marketplace.inventory.core.domain.entity.Item;
import com.uade.marketplace.inventory.repository.ItemRepository;
import com.uade.marketplace.payments.core.domain.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ConsumeOrderCreatedForStockMessage implements ConsumeMessage<OrderDTO> {

  private ItemRepository itemRepository;

  @Override
  public void accept(OrderDTO orderDTO) {
    Item item = itemRepository.findById(orderDTO.getItemId());

    item = item.withQuantity(item.getQuantity() - orderDTO.getQuantity());
    itemRepository.save(item);
  }
}
