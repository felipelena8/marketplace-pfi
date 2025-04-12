package com.uade.marketplace.inventory.router.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class DefaultAdvisor {

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ApiError> handleRuntimeException(RuntimeException e) {
    HttpStatus status = HttpStatus.FAILED_DEPENDENCY;
    log.error(e.getMessage());
    return ResponseEntity.status(status.value())
        .body(
            ApiError.builder()
                .message(e.getMessage())
                .code(status.getReasonPhrase())
                .message(e.getMessage())
                .build());
  }
}
