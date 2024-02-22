package com.dynamite.facebook.model.dto.auth;

import com.dynamite.facebook.model.dto.user.UserDTO;
import com.dynamite.facebook.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLogin {
    private String token;
    private UserDTO user;
}
