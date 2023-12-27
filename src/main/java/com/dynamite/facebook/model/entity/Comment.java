package com.dynamite.facebook.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name="post_id", referencedColumnName = "id")
    private Post post;
    @Column(name = "create_at")
    private Timestamp createdAt;
    @Column(name = "react_count")
    private Long reactCount;
    @Column(name = "is_root")
    private int isRoot;
    @Column(name = "parent_id")
    private Long parentId;
    @Column(name = "resources")
    private String resources;
    @Column(name = "content")
    private String content;
}
