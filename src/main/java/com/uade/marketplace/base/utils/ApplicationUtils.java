package com.uade.marketplace.base.utils;

import com.uade.marketplace.base.core.exception.BadRequestException;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class ApplicationUtils {

  private static final String MODULE_VARIABLE_NAME = "module";

  private ApplicationUtils() {}

  public static Module getModule() {
    try {
      return Module.getModuleByValue(System.getenv(MODULE_VARIABLE_NAME));
    } catch (Exception e) {
      return Module.BASE;
    }
  }

  @AllArgsConstructor
  @Getter
  public enum Module {
    BASE("base"),
    ORDERS("orders"),
    PAYMENTS("payments"),
    INVENTORY("inventory"),
    NOTIFICATIONS("notifications"),
    SHIPMENTS("shipments");

    private final String value;

    public static Module getModuleByValue(String value) {
      return Arrays.stream(Module.values())
          .filter(m -> m.getValue().equals(value))
          .findFirst()
          .orElseThrow(() -> new BadRequestException(String.format("Module %s not found", value)));
    }
  }
}
