package com.uade.marketplace.orders.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
    scanBasePackages = {"com.uade.marketplace.orders", "com.uade.marketplace.base"})
@EnableJpaRepositories(basePackages = "com.uade.marketplace.orders.repository")
@EntityScan(basePackages = "com.uade.marketplace.orders.core.domain")
public class OrdersSpringConfig {}
