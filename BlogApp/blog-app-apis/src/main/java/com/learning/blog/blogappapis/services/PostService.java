package com.learning.blog.blogappapis.services;

import com.learning.blog.blogappapis.entity.Category;
import com.learning.blog.blogappapis.entity.Post;
import com.learning.blog.blogappapis.entity.User;
import com.learning.blog.blogappapis.payloads.PostDto;
import com.learning.blog.blogappapis.payloads.PostsResponses;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
    //update
    PostDto updatePost(PostDto postDto,Integer postId);
    //delete by id
    void deletePost(Integer postId);
    // get all posts
    PostsResponses getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);
    // get a single post by id
    PostDto getPostById(Integer postId);

    // get all post in a category

    List<PostDto> getPostByCategory(Integer categoryId);

    // get all post by a user
    List<PostDto> getPostByUser(Integer userId);

    // search post using keyword
    List<PostDto> searchPost(String keyword);

}
