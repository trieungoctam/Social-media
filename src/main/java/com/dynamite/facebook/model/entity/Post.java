package com.dynamite.facebook.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "`share_id`")
    private Long shareId;
    @ManyToOne
    @JoinColumn(name = "create_by", referencedColumnName = "id")
    private User user;
    @Column(name = "create_at")
    private Timestamp createdAt;
    @Column(name = "update_at")
    private Timestamp updateTime;
    @Column(name = "resources")
    private String resources;
    @Column(name = "content")
    private String content;
    @Column(name = "react_count")
    private Long react_count;
    @Column(name = "public")
    private int published;
}
