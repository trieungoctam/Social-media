package com.dynamite.facebook.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "date_of_birth")
    private Timestamp dateOfBirth;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "status")
    private int status;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Column(name = "friend_count")
    private Long friendCount;
    @Column(name = "about")
    private String about;
}
