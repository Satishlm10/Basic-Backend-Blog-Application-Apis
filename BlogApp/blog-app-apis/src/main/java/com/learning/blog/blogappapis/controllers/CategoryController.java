package com.learning.blog.blogappapis.controllers;

import com.learning.blog.blogappapis.payloads.ApiResponses;
import com.learning.blog.blogappapis.payloads.CategoryDto;
import com.learning.blog.blogappapis.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCat = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCat, HttpStatus.CREATED);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId){
        CategoryDto updatedcat = this.categoryService.updateCategory(categoryDto,catId);
        return new ResponseEntity<CategoryDto>(updatedcat, HttpStatus.OK);
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponses> deleteCategory(@PathVariable Integer catId){
       this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponses>(new ApiResponses("Category deleted",true), HttpStatus.OK);
    }

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
        CategoryDto category = this.categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto>  categories = this.categoryService.getCategories();
        return new ResponseEntity<List<CategoryDto>>(categories, HttpStatus.OK);
    }


}
