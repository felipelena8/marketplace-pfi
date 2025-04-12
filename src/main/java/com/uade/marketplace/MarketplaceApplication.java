package com.uade.marketplace;

import com.uade.marketplace.base.config.SpringConfig;
import com.uade.marketplace.base.utils.ApplicationUtils;
import com.uade.marketplace.base.utils.ApplicationUtils.Module;
import com.uade.marketplace.inventory.config.InventorySpringConfig;
import com.uade.marketplace.notifications.config.NotificationsSpringConfig;
import com.uade.marketplace.orders.config.OrdersSpringConfig;
import com.uade.marketplace.payments.config.PaymentsSpringConfig;
import com.uade.marketplace.shipments.config.ShipmentsSpringConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@Slf4j
public class MarketplaceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(getConfigClass()).run(args);
    }

    private static Class<?> getConfigClass() {
        final Module module = ApplicationUtils.getModule();
        log.info("Starting application for module: {}", module.toString());
        return switch (module) {
            case ORDERS -> OrdersSpringConfig.class;
            case INVENTORY -> InventorySpringConfig.class;
            case PAYMENTS -> PaymentsSpringConfig.class;
            case SHIPMENTS -> ShipmentsSpringConfig.class;
            case NOTIFICATIONS -> NotificationsSpringConfig.class;
            default -> SpringConfig.class;
        };
    }
}
