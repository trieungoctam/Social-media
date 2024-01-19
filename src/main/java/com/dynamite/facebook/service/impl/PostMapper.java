package com.dynamite.facebook.service.impl;

import com.dynamite.facebook.model.dto.post.ResponsePost;
import com.dynamite.facebook.model.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public ResponsePost toResponsePost(Post post) {
        ResponsePost responsePost = new ResponsePost();
        responsePost.setId(post.getId());
        responsePost.setShareId(post.getShareId());
        responsePost.setUserId(post.getUser().getId());
        responsePost.setResources(post.getResources());
        responsePost.setContent(post.getContent());
        responsePost.setReactCount(post.getReact_count());
        responsePost.setPublished(post.getPublished());
        return responsePost;
    }
}
