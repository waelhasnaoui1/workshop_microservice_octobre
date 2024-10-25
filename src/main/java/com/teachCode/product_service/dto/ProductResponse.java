package com.teachCode.product_service.dto;

import java.math.BigDecimal;

public record ProductResponse (long id, String name, String description, BigDecimal price, Long categoryId,

                               Long quantity) {
}
