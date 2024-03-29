package com.learning.blog.blogappapis.repositories;

import com.learning.blog.blogappapis.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
