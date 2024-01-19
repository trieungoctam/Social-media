package com.dynamite.facebook.service.impl;

import com.dynamite.facebook.constant.ResponseValue;
import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.dto.CommentDTO;
import com.dynamite.facebook.model.entity.Comment;
import com.dynamite.facebook.model.entity.Post;
import com.dynamite.facebook.model.entity.User;
import com.dynamite.facebook.repository.CommentRepository;
import com.dynamite.facebook.repository.PostRepository;
import com.dynamite.facebook.repository.UserRepository;
import com.dynamite.facebook.service.ICommentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Comment save(CommentDTO comment) throws ResponseException {
        User user = userRepository.findById(comment.getUserId()).orElse(null);
        Post post = postRepository.findById(comment.getPostId()).orElse(null);
        Comment newComment = new Comment();
        if (comment.getCreatedAt() == null) {
            newComment.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
        } else {
            newComment.setCreatedAt(comment.getCreatedAt());
        }
        newComment.setContent(comment.getContent());
        newComment.setUser(user);
        newComment.setPost(post);
        newComment.setParentId(comment.getParentId());
        newComment.setResources(comment.getResources());
        newComment.setIsRoot(comment.getIsRoot());
        newComment.setReactCount(comment.getReactCount());
        newComment = commentRepository.save(newComment);
        return newComment;
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> findAllByPostId(Long postId) {
        return commentRepository.findAllByPostId(postId);
    }

    @Override
    public Comment update(Long id, Comment comment) {
        return commentRepository.save(comment);
    }
}
