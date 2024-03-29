package com.learning.blog.blogappapis.services;

import com.learning.blog.blogappapis.payloads.CategoryDto;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer id);
    CategoryDto getCategory(Integer id);
    void deleteCategory(Integer id);

    List<CategoryDto> getCategories();
}
