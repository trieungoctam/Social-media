package com.dynamite.facebook.service;

import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.dto.user.UserDTO;
import com.dynamite.facebook.model.entity.User;

import java.util.List;

public interface IUserService {
    User test();
    List<User> getAllUser();
    User getUserById(Long userId) throws ResponseException;
    User addUser(User user) throws ResponseException;
    List<User> addUsers(List<User> users);
    User updateUser(Long id, UserDTO user) throws ResponseException;
    List<User> updateUsers(List<User> users);
    void deleteUser(int userId);
    void deleteUsers(List<Long> userIds);
    User getUserByUsername(String username);
}
