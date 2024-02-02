package com.dynamite.facebook.service.impl;

import com.dynamite.facebook.constant.ResponseValue;
import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.entity.Post;
import com.dynamite.facebook.model.entity.User;
import com.dynamite.facebook.model.entity.UserReactPost;
import com.dynamite.facebook.repository.PostRepository;
import com.dynamite.facebook.repository.UserReactPostRepository;
import com.dynamite.facebook.repository.UserRepository;
import com.dynamite.facebook.service.IUserReactPostService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReactPostService implements IUserReactPostService {
    @Autowired
    private UserReactPostRepository userReactPostRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public void addReact(Long postId, Long userId, int reactType) throws ResponseException {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseException(ResponseValue.NOT_FOUND));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseException(ResponseValue.NOT_FOUND));
        post.setReact_count(post.getReact_count() + 1);
        UserReactPost userReactPost = new UserReactPost();
        userReactPost.setPost(post);
        userReactPost.setUser(user);
        userReactPost.setReactType(reactType);
        postRepository.save(post);
        userReactPostRepository.save(userReactPost);
    }

    @Override
    @Transactional
    public void removeReact(Long postId, Long userId) throws ResponseException {
        UserReactPost userReactPost = userReactPostRepository.findByPost_IdAndUser_Id(postId, userId);
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseException(ResponseValue.NOT_FOUND));
        Long reactCount = post.getReact_count();
        if (reactCount > 0) reactCount -= 1;
        post.setReact_count(reactCount);
        postRepository.save(post);
        userReactPostRepository.deleteById(userReactPost.getId());
    }

    @Override
    public List<UserReactPost> findAllByPost_Id(Long postId) {
        return userReactPostRepository.findAllByPost_Id(postId);
    }
}
