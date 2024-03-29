package com.learning.blog.blogappapis.services;

import com.learning.blog.blogappapis.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId);
    void deleteComment(Integer commentId);
}
