package com.learning.blog.blogappapis.controllers;

import com.learning.blog.blogappapis.entity.Comment;
import com.learning.blog.blogappapis.payloads.ApiResponses;
import com.learning.blog.blogappapis.payloads.CommentDto;
import com.learning.blog.blogappapis.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @PostMapping("post/{postId}/comment")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId){
            CommentDto createdComment = this.commentService.createComment(comment,postId);
            return new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);
    }

    @DeleteMapping("comment/{commentId}")
    public ResponseEntity<ApiResponses> deleteComment( @PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponses>(new ApiResponses("Comment deletd succesfully",true),HttpStatus.OK);
    }

}
