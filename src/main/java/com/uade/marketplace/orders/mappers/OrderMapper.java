package com.uade.marketplace.orders.mappers;

import static org.mapstruct.factory.Mappers.*;

import com.uade.marketplace.orders.core.domain.Order;
import com.uade.marketplace.orders.core.domain.dto.OrderDTO;
import org.mapstruct.Mapper;

@Mapper
public abstract class OrderMapper {

  public static final OrderMapper INSTANCE = getMapper(OrderMapper.class);

  public abstract Order orderDTOToOrder(OrderDTO order);

  public abstract OrderDTO orderToOrderDTO(Order order);
}
