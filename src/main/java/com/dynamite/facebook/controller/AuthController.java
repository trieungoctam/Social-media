package com.dynamite.facebook.controller;

import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.dto.auth.RequestLogin;
import com.dynamite.facebook.model.dto.auth.RequestSignUp;
import com.dynamite.facebook.model.dto.auth.ResponseLogin;
import com.dynamite.facebook.model.dto.auth.ResponseSignUp;
import com.dynamite.facebook.model.entity.User;
import com.dynamite.facebook.service.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class AuthController {
    private final IAuthService authenService;

    @PostMapping("/signup")
    public ResponseSignUp signUp(@RequestBody RequestSignUp requestInputSignUp) throws ResponseException {
        return authenService.signUp(requestInputSignUp);
    }

    @PostMapping("/signin")
    public ResponseLogin signIn(@RequestBody RequestLogin requestInputLogin) throws ResponseException {
        return authenService.signIn(requestInputLogin);
    }

}
