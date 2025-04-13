package com.uade.marketplace.orders.core.usecase;

import com.amazonaws.services.sqs.AmazonSQS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uade.marketplace.base.core.usecase.SendMessageSqs;
import com.uade.marketplace.orders.core.domain.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SendOrderCreatedMessage extends SendMessageSqs<OrderDTO> {

  public SendOrderCreatedMessage(
      ObjectMapper objectMapper,
      @Value("${topics.order-created.url}") String queueUrl,
      AmazonSQS sqsClient) {
    super(objectMapper, queueUrl, sqsClient);
  }
}
