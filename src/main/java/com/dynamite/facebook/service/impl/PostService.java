package com.dynamite.facebook.service.impl;

import com.dynamite.facebook.constant.ResponseValue;
import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.dto.post.RequestPost;
import com.dynamite.facebook.model.entity.Post;
import com.dynamite.facebook.model.entity.User;
import com.dynamite.facebook.repository.PostRepository;
import com.dynamite.facebook.repository.UserRepository;
import com.dynamite.facebook.service.ICacheService;
import com.dynamite.facebook.service.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService implements IPostService, ICacheService<Post> {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    @Override
    @Transactional
    public Post createPost(Long userId, String url, String content) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = new Post();
        post.setUser(user);
        post.setResources(url);
        post.setContent(content);
        post.setPublished(1);
        post.setReact_count(0L);
        post.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
        post = postRepository.save(post);
        return post;
    }

    @Override
    public List<Post> getPostByUserId(Long userId) {
        return postRepository.findAllByUser_Id(userId);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public Post updatePost(Long postId, RequestPost requestPost) throws ResponseException {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseException(ResponseValue.NOT_FOUND));
        post.setContent(requestPost.getContent());
        post.setResources(requestPost.getResources());
        post.setPublished(requestPost.getPublished());
        postRepository.save(post);
        return post;
    }

    @Override
    public Post getPostById(Long postId) throws ResponseException {
        return postRepository.findById(postId).orElseThrow(() -> new ResponseException(ResponseValue.NOT_FOUND));
    }


    @Override
    public Post getBackendData(Long key) throws ResponseException {
        return getPostById(key);
    }
}
