package com.teachCode.product_service.service.category;

import com.teachCode.product_service.dto.CategoryRequest;
import com.teachCode.product_service.entities.Category;
import com.teachCode.product_service.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryRequest categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.name());
        category.setDescription(categoryDTO.description());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
