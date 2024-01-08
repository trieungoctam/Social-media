package com.dynamite.facebook.service;

import com.dynamite.facebook.model.entity.Post;

import java.util.List;

public interface IPostService {
    Post createPost(Long userId, String url, String content);
    List<Post> getPostByUserId(Long userId);
}
