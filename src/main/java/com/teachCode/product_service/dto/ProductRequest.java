package com.teachCode.product_service.dto;

import java.math.BigDecimal;

public record ProductRequest(int id, String name, String description, BigDecimal price, Long categoryId,byte[] img,long quantity) {
}
