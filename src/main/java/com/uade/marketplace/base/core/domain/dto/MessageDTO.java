package com.uade.marketplace.base.core.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class MessageDTO<T> {

  private T body;
}
