package com.teachCode.product_service.service.product;

import com.teachCode.product_service.dto.ProductRequest;
import com.teachCode.product_service.dto.ProductResponse;
import com.teachCode.product_service.entities.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    ProductResponse addProduct(ProductRequest productRequest) throws IOException;

    List<Product> getAllProduct();


}
