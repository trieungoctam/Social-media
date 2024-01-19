package com.dynamite.facebook.controller;

import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.dto.CommentDTO;
import com.dynamite.facebook.model.entity.Comment;
import com.dynamite.facebook.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @GetMapping("/")
    public List<Comment> findAll(){
        return commentService.findAll();
    }
    @GetMapping("/{id}")
    public Comment findById(@PathVariable Long id){
        return commentService.findById(id);
    }
    @PostMapping("/")
    public Comment save(@RequestBody CommentDTO commentDTO) throws ResponseException {
        return commentService.save(commentDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        commentService.deleteById(id);
    }
    @PutMapping("/{id}")
    public Comment update(@PathVariable Long id, @RequestBody Comment comment) {
        return commentService.update(id, comment);
    }
}
