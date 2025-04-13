package com.uade.marketplace.payments.core.exception.usecase;

import com.uade.marketplace.base.core.usecase.ConsumeMessage;
import com.uade.marketplace.payments.core.domain.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumeOrderCreatedMessage implements ConsumeMessage<OrderDTO> {

  @Override
  public void accept(OrderDTO orderDTO) {
    log.info("Payment generated for order: {}", orderDTO);
  }
}
