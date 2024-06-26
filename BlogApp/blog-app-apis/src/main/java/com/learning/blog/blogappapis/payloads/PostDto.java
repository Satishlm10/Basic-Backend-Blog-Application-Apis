package com.learning.blog.blogappapis.payloads;

import com.learning.blog.blogappapis.entity.Category;
import com.learning.blog.blogappapis.entity.Comment;
import com.learning.blog.blogappapis.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Integer postId;
    private String title;

    private String content;

    private String imageName;

    private UserDto user;

    private CategoryDto category;

    private Set<CommentDto> comments = new HashSet<>();


}
