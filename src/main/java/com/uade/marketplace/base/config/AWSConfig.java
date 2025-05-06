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
        new BasicSessionCredentials("ASIA3D6HGFMM3ACPYCRB", "KU7qeCicp1vJQkx2GjgD90CpggKe+g6ddvqJ5ofV",
            "IQoJb3JpZ2luX2VjEJL//////////wEaCXVzLXdlc3QtMiJIMEYCIQCL+kAsumstnpki+1vESyosSzxuas5Ld3nk0GcZZPApngIhAMv1/IIOXu6yu74V+GpIHlBzlotiXRfZn8014SCMxOq6KqgCCDsQARoMNzY0Mzg1MDQ1MjczIgzefd+aa+3aaJgsBN0qhQLxPRV5uQemF+vB4oa555V+a4CxHtXEOsbd3XSekPdJBcOst/ywdWDjwxgLSZ7KpzAxL3hDX0Kmy6vpzDeOp3CsAS4K8OahwfyC2fCr8txRJkNf5AHDFEd+TAzHwUixrmAV6tmMyvlkNEPMBRWonKVkfI94o7M0+TAs46qMOrPXrJFkHUkqP53zvOoK2B69BGYqqlTTKz/pumCh+oy9eYus06yMZkpOFb/uBm2IyBeNpEvkzBZdldHTNv2DbX+e6wqIh+oWbBu0D71T6d+eUG+9I5h6MNuntPije8/X3YgsHNQWzaJtys5V2kJfeMIU5pTyk62c34AvnzcIgjOVVBD6yOrVpUow+snlwAY6nAEgvUyNK7YyBBkQDZRzXRaU2Uo8bHY8gFTPKk0jJhYAb588MEunao8O3gjCPHWRU8rCyxnaFoucUP1UK13+WK+XXmfoRTFbanEhE76u5jkqwiN0egNrvu7cy+K/QZoezM/UQoSnF4NqtjIelq6b4wn4Ng2ICeO1wwvjkI3mgKFNzH7Et++GYI+Uv60y23Ghi2K8EFm1hejswsBx1xY=");
    return AmazonSQSClientBuilder.standard()
        .withRegion(Regions.fromName(region))
        .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
        .build();
  }
}