package com.dynamite.facebook.service;

import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.dto.CommentDTO;
import com.dynamite.facebook.model.entity.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    Comment findById(Long id);
    Comment save(CommentDTO comment) throws ResponseException;
    void deleteById(Long id);
    List<Comment> findAllByPostId(Long postId);
    Comment update(Long id, Comment comment);
}
