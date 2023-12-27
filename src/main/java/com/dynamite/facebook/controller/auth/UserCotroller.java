package com.dynamite.facebook.controller.auth;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserCotroller {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Hello World";
    }
}
