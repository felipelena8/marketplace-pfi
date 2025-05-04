package com.uade.marketplace.base.core.usecase;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SendMessageSqs<T> implements Consumer<T> {

  private final ObjectMapper objectMapper;
  private final List<String> queueUrls;
  private final AmazonSQS sqsClient;

  public SendMessageSqs(final ObjectMapper objectMapper, List<String> queueUrls, final AmazonSQS sqsClient) {
    this.objectMapper = objectMapper;
    this.queueUrls = queueUrls;
    this.sqsClient = sqsClient;
  }

  @Override
  public void accept(T t) {
    try {
      final String message = objectMapper.writeValueAsString(t);
      for (String queueUrl : queueUrls) {
        sendMessageToSqs(message, queueUrl);
      }

      log.info("Sending message to SQS: {}", message);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void sendMessageToSqs(String message, String queueUrl) {
    final SendMessageRequest sendMsgRequest = new SendMessageRequest().withQueueUrl(queueUrl).withMessageBody(message).withDelaySeconds(5);
    sqsClient.sendMessage(sendMsgRequest);
  }
}
