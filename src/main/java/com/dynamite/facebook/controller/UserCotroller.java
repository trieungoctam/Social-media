package com.dynamite.facebook.controller;

import com.dynamite.facebook.constant.ResponseValue;
import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.dto.user.UserDTO;
import com.dynamite.facebook.model.entity.User;
import com.dynamite.facebook.service.IUserService;
import com.dynamite.facebook.service.UserMapper;
import com.dynamite.facebook.util.LoadingCacheStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserCotroller {

    @Autowired
    private IUserService userService;
    @Autowired
    private LoadingCacheStore<User> userLoadingCacheStore;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    @ResponseBody
    public List<UserDTO> getAllUser() {
        return userService.getAllUser().stream().map(userMapper::toUserDTO).toList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserDTO getUserById(@PathVariable("id") Long id) throws ResponseException {
        try {
            return userMapper.toUserDTO(userLoadingCacheStore.get(id));
        } catch (Exception e) {
            throw new ResponseException(ResponseValue.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public UserDTO updateUserById(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) throws ResponseException {
        try {
            User user = userService.updateUser(id, userDTO);
            userLoadingCacheStore.put(id, user);
            return userMapper.toUserDTO(user);
        }catch (Exception e){
            throw new ResponseException(ResponseValue.BAD_REQUEST);
        }
    }
}
