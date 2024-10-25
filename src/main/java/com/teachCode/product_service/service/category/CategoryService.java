package com.teachCode.product_service.service.category;

import com.teachCode.product_service.dto.CategoryRequest;
import com.teachCode.product_service.entities.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(CategoryRequest categoryDTO);

    List<Category> getAllCategories();

}
