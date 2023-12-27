package com.dynamite.facebook.model.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestSignUp {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}
