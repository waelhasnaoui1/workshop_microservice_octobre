package com.teachCode.product_service.service.product;

import com.teachCode.product_service.dto.ProductRequest;
import com.teachCode.product_service.dto.ProductResponse;
import com.teachCode.product_service.entities.Category;
import com.teachCode.product_service.entities.Product;
import com.teachCode.product_service.repository.CategoryRepository;
import com.teachCode.product_service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) throws IOException {
        Optional<Category> categoryOpt = categoryRepository.findById(productRequest.categoryId());
        if(categoryOpt.isEmpty()){
            throw new IOException("Category with ID" + productRequest.categoryId() + " not found");
        }
        Category category = categoryOpt.get();

        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .category(category)
                .price(productRequest.price())
                .quantity(productRequest.quantity())
                .build();

        productRepository.save(product);

        log.info("Product {} is saved", product.getId());

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                category.getId(),
                product.getQuantity()
                );

    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }
}
