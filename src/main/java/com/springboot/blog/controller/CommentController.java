package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComemnt(@PathVariable(value="postId") long postid,
                                                    @Valid @RequestBody CommentDto commentDto)
    {
        return new ResponseEntity<>(commentService.createComment(postid,commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable(value="postId") long postId)
    {
        return ResponseEntity.ok(commentService.getCommentByPostId(postId));
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value="postId") long postId,
                                                     @PathVariable(value="commentId") long commentId)
    {
        return ResponseEntity.ok(commentService.getCommentById(postId,commentId));
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public  ResponseEntity<CommentDto> updateComment(@PathVariable(value="postId") long postId,
                                                     @PathVariable(value="commentId") long commentId,
                                                     @Valid  @RequestBody CommentDto commentDto)
    {
        return new ResponseEntity<>(commentService.updateComment(postId,commentId,commentDto),HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deletecomment(@PathVariable(value="postId") long postId,
                                                     @PathVariable(value="commentId") long commentId)
    {
        commentService.deleteComment(postId,commentId);
        return new ResponseEntity<>("comment deleted successfully",HttpStatus.OK);
    }
}
