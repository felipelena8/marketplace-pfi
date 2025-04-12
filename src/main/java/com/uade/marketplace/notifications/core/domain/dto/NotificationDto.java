package com.uade.marketplace.notifications.core.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class NotificationDto {
    @With
    private String id;
    private String email;
    private String message;
}
