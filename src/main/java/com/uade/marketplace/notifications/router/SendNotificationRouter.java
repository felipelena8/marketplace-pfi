package com.uade.marketplace.notifications.router;

import com.uade.marketplace.notifications.core.domain.dto.NotificationDto;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SendNotificationRouter {

  @PostMapping("/notifications")
  public ResponseEntity<NotificationDto> getPayment(@RequestBody NotificationDto notification) {
    return ResponseEntity.ok().body(notification.withId(UUID.randomUUID().toString()));
  }
}
