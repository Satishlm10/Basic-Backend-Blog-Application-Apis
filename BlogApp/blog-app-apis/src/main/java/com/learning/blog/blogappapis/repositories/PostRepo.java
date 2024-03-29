package com.learning.blog.blogappapis.repositories;

import com.learning.blog.blogappapis.entity.Category;
import com.learning.blog.blogappapis.entity.Post;
import com.learning.blog.blogappapis.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer > {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}
