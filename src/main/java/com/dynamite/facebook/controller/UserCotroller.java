package com.dynamite.facebook.controller;

import com.dynamite.facebook.model.entity.User;
import com.dynamite.facebook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserCotroller {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    @ResponseBody
    public User getAllUser() {
        return userService.test();
    }
}
