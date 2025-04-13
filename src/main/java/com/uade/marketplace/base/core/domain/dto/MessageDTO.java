package com.uade.marketplace.base.core.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDTO<T> {

  private T body;
}
