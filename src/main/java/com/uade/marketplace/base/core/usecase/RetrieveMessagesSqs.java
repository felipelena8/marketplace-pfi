package com.uade.marketplace.base.core.usecase;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uade.marketplace.base.core.domain.dto.MessageDTO;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.function.Supplier;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

public abstract class RetrieveMessagesSqs<T> implements Supplier<Void> {

  private final ObjectMapper objectMapper;
  private final String queueUrl;
  private final AmazonSQS sqsClient;
  private final int delay;
  private final TaskScheduler taskScheduler;
  private final ConsumeMessage<T> consumeMessage;

  public RetrieveMessagesSqs(
      final ObjectMapper objectMapper,
      final String queueUrl,
      final AmazonSQS sqsClient,
      final int delay,
      ConsumeMessage<T> consumeMessage) {
    this.objectMapper = objectMapper;
    this.queueUrl = queueUrl;
    this.sqsClient = sqsClient;
    this.delay = delay;
    this.consumeMessage = consumeMessage;
    this.taskScheduler = new ThreadPoolTaskScheduler();
    ((ThreadPoolTaskScheduler) this.taskScheduler).initialize();
  }

  @PostConstruct
  public void scheduleTask() {
    taskScheduler.scheduleWithFixedDelay(this::get, delay);
  }

  @Override
  public Void get() {
    ReceiveMessageRequest receiveMessageRequest =
        new ReceiveMessageRequest(queueUrl).withMaxNumberOfMessages(10);
    List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).getMessages();

    messages.forEach(this::processMessage);
    return null;
  }

  private void processMessage(Message message) {
    try {
      MessageDTO<T> messageDTO = mapMessageToDTO(message);
      consumeMessage.accept(messageDTO.getBody());
      sqsClient.deleteMessage(queueUrl, message.getReceiptHandle());
    } catch (Exception e) {
      throw new RuntimeException("Error processing message", e);
    }
  }

  private MessageDTO<T> mapMessageToDTO(Message message) {
    try {
      T body = objectMapper.readValue(message.getBody(), getTypeReference());
      return MessageDTO.<T>builder().body(body).build();
    } catch (Exception e) {
      throw new RuntimeException("Error mapping message to DTO", e);
    }
  }

  protected TypeReference<T> getTypeReference() {
    return new TypeReference<T>() {};
  }
}
