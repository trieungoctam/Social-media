package com.dynamite.facebook.service;

import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.dto.post.RequestPost;
import com.dynamite.facebook.model.entity.Post;

import java.util.List;

public interface IPostService {
    Post createPost(Long userId, String url, String content);
    List<Post> getPostByUserId(Long userId);
    void deletePost(Long postId);
    Post updatePost(Long postId, RequestPost requestPost) throws ResponseException;
    Post getPostById(Long postId) throws ResponseException;
}
