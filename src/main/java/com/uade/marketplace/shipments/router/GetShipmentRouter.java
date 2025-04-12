package com.uade.marketplace.shipments.router;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetShipmentRouter {

    @GetMapping("/shipments/{shipment_id}")
    public ResponseEntity<String> getPayment(@PathVariable("shipment_id") String shipmentId) {
        return ResponseEntity.ok().body(shipmentId);
    }
}
