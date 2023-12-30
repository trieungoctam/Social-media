package com.dynamite.facebook.service.impl;

import com.dynamite.facebook.constant.ResponseValue;
import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.entity.User;
import com.dynamite.facebook.repository.UserRepository;
import com.dynamite.facebook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User test() {
        return new User();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) throws ResponseException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResponseException(ResponseValue.NOT_FOUND));
    }

    @Override
    public User addUser(User user) throws ResponseException {
        if (userRepository.findByUsername(user.getUsername()).isPresent())
            throw new ResponseException(ResponseValue.CONFLICT);
        return userRepository.save(user);
    }

    @Override
    public List<User> addUsers(List<User> users) {
        return null;
    }

    @Override
    public User updateUser(User user) throws ResponseException {
        if (!userRepository.findById(user.getId()).isPresent())
            throw  new ResponseException(ResponseValue.NOT_FOUND);
        return userRepository.save(user);
    }

    @Override
    public List<User> updateUsers(List<User> users) {
        return null;
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById((long) userId);
    }

    @Override
    public void deleteUsers(List<Long> userIds) {

    }
}
