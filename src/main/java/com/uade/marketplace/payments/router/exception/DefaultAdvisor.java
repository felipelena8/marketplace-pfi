package com.uade.marketplace.payments.router.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvisor {

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ApiError> handleRuntimeException(RuntimeException e) {
    HttpStatus status = HttpStatus.FAILED_DEPENDENCY;
    return ResponseEntity.status(status.value())
        .body(
            ApiError.builder()
                .message(e.getMessage())
                .code(status.getReasonPhrase())
                .message(e.getMessage())
                .build());
  }
}
