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
  private String awsId;

  @Value("${aws.secret-access-key}")
  private String awsKey;

  @Value("${aws.region}")
  private String region;

  @Bean
  public AmazonSQS sqsClient() {
    BasicSessionCredentials basicAWSCredentials =
        new BasicSessionCredentials("ASIA3D6HGFMMTTIJBVWU", "16DKzwPUiLx2MPEYFoHx+6bW2Md5rNwYv2+B1KgK",
            "IQoJb3JpZ2luX2VjEHQaCXVzLXdlc3QtMiJHMEUCIQCH+lepjQDU8BY4zBrDUOeNk9aKSxF77t/jLIZofC6nEAIgW6j92gazUIOVD7+te1ds2CjjHL8QsccROCdOf9y7TsIqqAIIHRABGgw3NjQzODUwNDUyNzMiDFWxtisIpvtER2sbLCqFAq8sFo0OZV+0UxLIyau2Fhs3XfaWHHRVW0/cAO5Lz10l8Kr7r3UfFNYQ2xZJ2MULEu38PbFJaNvqbywDNmsMn9Jfma3fg7+ZgIieK2XO78cqmSn/5bfQt8OW4da241QMYuzyf4Ujigp+v5YX3L1Wg6p3nQI3qx3M1wdaejZgnDpXgD2rekTsGi1cI0sGqYYG5VhlW6+05Ujy9Xp7KNKTf3+B7OPzk+OGxxxTqCEW2Miakidj/7mjC8rSGdgv9BZBOKXnloVaPZKbwwGQoHmJ3LaBiT98sBSWIYJtPFUTk60bK2hx4DQN94STqoburzzu5pGepW97J/9tBaV4fVeZMl8IPdTROzCrlN/ABjqdAXJnvbcinwv6tRX96WFvPzPwV5F+jNcjzrlv019uzmTmIaDj9AjHP4wqR2Sw6rSrLBrMXOcNEB2Ar3N2mIq12wax5SESkURSH/UrZ1Yk2g2wecwO2AfTn+n7kRaujRzFEUrfAc2QqTyYGOoWAKqQfWMSg25LCSX7TFOYXhaunNKZyClNafVR42qlcE7KnokHv9RsSB7sr+HOS6w5c/Y=");
    return AmazonSQSClientBuilder.standard()
        .withRegion(Regions.fromName(region))
        .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
        .build();
  }
}