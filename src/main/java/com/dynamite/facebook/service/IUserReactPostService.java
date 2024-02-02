package com.dynamite.facebook.service;

import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.entity.UserReactPost;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserReactPostService {
    void addReact(Long postId, Long userId,int reactType) throws ResponseException;
    void removeReact(Long postId, Long userId) throws ResponseException;

    List<UserReactPost> findAllByPost_Id(Long postId);
}
