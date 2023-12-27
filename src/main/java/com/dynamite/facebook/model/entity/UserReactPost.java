package com.dynamite.facebook.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_react_post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReactPost {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id"   )
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;
    @Column(name = "react_type")
    private int reactType;
}
