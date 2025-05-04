package com.uade.marketplace.payments.router;

import com.amazonaws.services.sqs.AmazonSQS;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uade.marketplace.base.core.usecase.RetrieveMessagesSqs;
import com.uade.marketplace.payments.core.domain.dto.OrderDTO;
import com.uade.marketplace.payments.core.exception.usecase.ConsumeOrderCreatedMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RetrieveOrderCreatedMessages extends RetrieveMessagesSqs<OrderDTO> {

  public RetrieveOrderCreatedMessages(ObjectMapper objectMapper, @Value("${topics.payments-queue.url}") String queueUrl,
      AmazonSQS sqsClient, @Value("${topics.payments-queue.delay:100}") int delay, ConsumeOrderCreatedMessage consumeMessage) {
    super(objectMapper, queueUrl, sqsClient, delay, consumeMessage);
  }

  @Override
  public TypeReference getTypeReference() {
    return new TypeReference<OrderDTO>() {
    };
  }
}
