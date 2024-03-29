package com.learning.blog.blogappapis.repositories;

import com.learning.blog.blogappapis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
