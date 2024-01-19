package com.dynamite.facebook.service;

import com.dynamite.facebook.model.dto.post.RequestPost;
import com.dynamite.facebook.model.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPostMapper {
    Post toPost(RequestPost requestPost);
}
