package com.uade.marketplace.payments.router;

import com.amazonaws.services.sqs.AmazonSQS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uade.marketplace.base.core.usecase.ConsumeMessage;
import com.uade.marketplace.base.core.usecase.RetrieveMessagesSqs;
import com.uade.marketplace.payments.core.domain.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RetrieveOrderCreatedMessages extends RetrieveMessagesSqs<OrderDTO> {

  public RetrieveOrderCreatedMessages(
      ObjectMapper objectMapper,
      @Value("${topics.order-created.url}") String queueUrl,
      AmazonSQS sqsClient,
      @Value("${topics.order-created.delay:100}") int delay,
      ConsumeMessage<OrderDTO> consumeMessage) {
    super(objectMapper, queueUrl, sqsClient, delay, consumeMessage);
  }
}
