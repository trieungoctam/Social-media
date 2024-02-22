package com.dynamite.facebook.service.impl;

import com.dynamite.facebook.constant.ResponseValue;
import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.dto.auth.RequestLogin;
import com.dynamite.facebook.model.dto.auth.RequestSignUp;
import com.dynamite.facebook.model.dto.auth.ResponseLogin;
import com.dynamite.facebook.model.dto.auth.ResponseSignUp;
import com.dynamite.facebook.model.dto.user.UserDTO;
import com.dynamite.facebook.model.entity.User;
import com.dynamite.facebook.repository.UserRepository;
import com.dynamite.facebook.service.IAuthService;
import com.dynamite.facebook.service.UserMapper;
import com.dynamite.facebook.service.UserRequestMapper;
import com.dynamite.facebook.service.UserResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

    private final UserRepository userRepository;

    private final UserRequestMapper userRequestMapper;

    private final UserResponseMapper userResponseMapper;

    private final AuthenticationManager authenticationManager;

    private final UserMapper userMapper;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;
    @Override
    public ResponseSignUp signUp(RequestSignUp requestInputSignUp) throws ResponseException{
        if (userRepository.existsByUsername(requestInputSignUp.getUsername()) || userRepository.existsByEmail(requestInputSignUp.getEmail()) ) {
            throw new ResponseException(ResponseValue.CONFLICT);
        }

        User user = userRequestMapper.toUser(requestInputSignUp);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return userResponseMapper.toResponseSignUp(user);
    }

    @Override
    public ResponseLogin signIn(RequestLogin requestInputLogin) throws ResponseException {
        User user = userRepository.findByUsername(requestInputLogin.getUsername())
                .orElseThrow(() -> new ResponseException(ResponseValue.NOT_FOUND));
        if (!passwordEncoder.matches(requestInputLogin.getPassword(), user.getPassword())) {
            throw new ResponseException(ResponseValue.UNAUTHORIZED);
        }
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestInputLogin.getUsername(), requestInputLogin.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String jwt = jwtService.generateTokenFromUsername(user.getUsername());
        UserDTO userDTO = userMapper.toUserDTO(user);
        return new ResponseLogin(jwt, userDTO);
    }

}
