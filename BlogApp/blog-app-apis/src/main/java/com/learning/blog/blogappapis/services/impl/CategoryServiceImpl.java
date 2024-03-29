package com.learning.blog.blogappapis.services.impl;

import com.learning.blog.blogappapis.entity.Category;
import com.learning.blog.blogappapis.exceptions.ResourceNotFoundException;
import com.learning.blog.blogappapis.payloads.CategoryDto;
import com.learning.blog.blogappapis.repositories.CategoryRepo;
import com.learning.blog.blogappapis.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category categoryAdded = this.categoryRepo.save(cat);
        return this.modelMapper.map(categoryAdded,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
       Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Catgory","Category Id",categoryId));
       cat.setCategoryTitle(categoryDto.getCategoryTitle());
       cat.setCategoryDescription(categoryDto.getCategoryDescription());
       Category updateCategory = this.categoryRepo.save(cat);
       return this.modelMapper.map(updateCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Catgory","Category Id",categoryId));
        return this.modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Catgory","Category Id",categoryId));
        this.categoryRepo.delete(cat);

    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map((cat)->this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }
}
