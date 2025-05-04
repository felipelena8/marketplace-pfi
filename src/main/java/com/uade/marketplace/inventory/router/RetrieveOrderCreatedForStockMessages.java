package com.uade.marketplace.inventory.router;

import com.amazonaws.services.sqs.AmazonSQS;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uade.marketplace.base.core.usecase.RetrieveMessagesSqs;
import com.uade.marketplace.inventory.core.usecase.ConsumeOrderCreatedForStockMessage;
import com.uade.marketplace.payments.core.domain.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RetrieveOrderCreatedForStockMessages extends RetrieveMessagesSqs<OrderDTO> {

  public RetrieveOrderCreatedForStockMessages(
      ObjectMapper objectMapper,
      @Value("${topics.inventory-queue.url}") String queueUrl,
      AmazonSQS sqsClient,
      @Value("${topics.inventory-queue.delay:100}") int delay,
      ConsumeOrderCreatedForStockMessage consumeMessage) {
    super(objectMapper, queueUrl, sqsClient, delay, consumeMessage);
  }

  @Override
  public TypeReference getTypeReference() {
    return new TypeReference<OrderDTO>() {
    };
  }
}
