package com.teachCode.product_service.controllers;

import com.teachCode.product_service.dto.ProductRequest;
import com.teachCode.product_service.dto.ProductResponse;
import com.teachCode.product_service.entities.Product;
import com.teachCode.product_service.service.product.ProductService;
import com.teachCode.product_service.service.product.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest)
            throws IOException, IOException {
        ProductResponse productResponse = productService.addProduct(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        List<ProductResponse> productResponses = new ArrayList<>();
        products.forEach(product -> {
            productResponses.add(
                    new ProductResponse(product.getId(),
                            product.getName(),
                            product.getDescription(),
                            product.getPrice(),
                            product.getCategory().getId(),
                            product.getQuantity()
                    ));
        });
        return ResponseEntity.ok(productResponses);
    }

}
