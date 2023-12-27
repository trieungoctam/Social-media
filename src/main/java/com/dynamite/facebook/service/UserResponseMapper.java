package com.dynamite.facebook.service;

import com.dynamite.facebook.model.dto.auth.ResponseSignUp;
import com.dynamite.facebook.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    ResponseSignUp toResponseSignUp(User user);
    User toUser(ResponseSignUp responseSignUp);
}
