package com.dynamite.facebook.service;

import com.dynamite.facebook.model.dto.user.UserDTO;
import com.dynamite.facebook.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
}
