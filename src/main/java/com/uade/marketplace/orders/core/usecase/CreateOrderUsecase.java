package com.uade.marketplace.orders.core.usecase;

import com.uade.marketplace.orders.core.domain.dto.OrderDTO;
import java.util.function.Function;

public interface CreateOrderUsecase extends Function<OrderDTO, OrderDTO> {}
