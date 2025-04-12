package com.uade.marketplace.shipments.router.exception;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiError {

    private int status;
    private String message;
    private String code;
}
