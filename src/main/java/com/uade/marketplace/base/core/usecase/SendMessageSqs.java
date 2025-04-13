package com.uade.marketplace.base.core.usecase;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SendMessageSqs<T> implements Consumer<T> {

  private final ObjectMapper objectMapper;
  private final String queueUrl;
  private final AmazonSQS sqsClient;

  public SendMessageSqs(
      final ObjectMapper objectMapper, final String queueUrl, final AmazonSQS sqsClient) {
    this.objectMapper = objectMapper;
    this.queueUrl = queueUrl;
    this.sqsClient = sqsClient;
  }

  @Override
  public void accept(T t) {
    try {
      final String message = objectMapper.writeValueAsString(t);
      final SendMessageRequest sendMsgRequest =
          new SendMessageRequest()
              .withQueueUrl(queueUrl)
              .withMessageBody(message)
              .withDelaySeconds(5);
      sqsClient.sendMessage(sendMsgRequest);

      log.info("Sending message to SQS: {}", message);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
