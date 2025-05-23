package com.uade.marketplace.base.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

  @Value("${aws.access-key-id}")
  private String accessKeyId;

  @Value("${aws.secret-access-key}")
  private String secretAccessKey;

  @Value("${aws.session-token}")
  private String awsSessionToken;

  @Value("${aws.region}")
  private String region;

  @Bean
  public AmazonSQS sqsClient() {
    BasicSessionCredentials basicAWSCredentials = new BasicSessionCredentials(accessKeyId, secretAccessKey, awsSessionToken);
    return AmazonSQSClientBuilder.standard().withRegion(Regions.fromName(region))
        .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).build();
  }
}