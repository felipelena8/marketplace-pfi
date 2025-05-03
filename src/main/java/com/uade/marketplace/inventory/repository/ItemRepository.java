package com.uade.marketplace.inventory.repository;

import com.uade.marketplace.inventory.core.domain.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository {

    List<Item> findAll();

    Item save(Item item);

    Item findById(String id);

}
