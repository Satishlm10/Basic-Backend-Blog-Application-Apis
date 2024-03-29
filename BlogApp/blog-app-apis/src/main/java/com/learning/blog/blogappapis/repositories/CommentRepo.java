package com.learning.blog.blogappapis.repositories;

import com.learning.blog.blogappapis.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
