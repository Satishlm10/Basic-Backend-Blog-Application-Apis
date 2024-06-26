package com.learning.blog.blogappapis.payloads;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;
    @NotBlank
    @Size(min = 3,message = "Category title must of 3 characters")
    private String categoryTitle;
    @NotBlank
    @Size(min = 10, message = "Description must have more than 10 characters")
    private String categoryDescription;
}
