package com.dynamite.facebook.service;

import com.dynamite.facebook.model.dto.auth.RequestSignUp;
import com.dynamite.facebook.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
    User toUser(RequestSignUp requestSignUp);
    RequestSignUp toRequestSignUp(User user);
}
