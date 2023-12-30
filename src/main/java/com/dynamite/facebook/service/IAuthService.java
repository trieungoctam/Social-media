package com.dynamite.facebook.service;

import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.dto.auth.RequestLogin;
import com.dynamite.facebook.model.dto.auth.RequestSignUp;
import com.dynamite.facebook.model.dto.auth.ResponseLogin;
import com.dynamite.facebook.model.dto.auth.ResponseSignUp;
import com.dynamite.facebook.model.entity.User;

import java.util.List;

public interface IAuthService {
    ResponseSignUp signUp(RequestSignUp requestInputSignUp) throws ResponseException;
    ResponseLogin signIn(RequestLogin requestInputLogin) throws ResponseException;
}
