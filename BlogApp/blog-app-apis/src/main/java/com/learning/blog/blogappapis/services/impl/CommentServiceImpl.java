package com.learning.blog.blogappapis.services.impl;

import com.learning.blog.blogappapis.entity.Comment;
import com.learning.blog.blogappapis.entity.Post;
import com.learning.blog.blogappapis.exceptions.ResourceNotFoundException;
import com.learning.blog.blogappapis.payloads.CommentDto;
import com.learning.blog.blogappapis.repositories.CommentRepo;
import com.learning.blog.blogappapis.repositories.PostRepo;
import com.learning.blog.blogappapis.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment =  this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","comment id",commentId));
        commentRepo.delete(comment);

    }
}
