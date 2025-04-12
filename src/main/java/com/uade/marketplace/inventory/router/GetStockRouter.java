package com.uade.marketplace.inventory.router;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetStockRouter {

    @GetMapping("/stocks/{item_id}")
    public ResponseEntity<String> getPayment(@PathVariable("item_id") String itemId) {
        return ResponseEntity.ok().body(itemId);
    }
}
