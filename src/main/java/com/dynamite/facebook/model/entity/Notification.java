package com.dynamite.facebook.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "notification")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
    @Column(name = "url")
    private String url;
    @Column(name = "description")
    private String description;
    @Column(name = "create_at")
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name="create_by", referencedColumnName = "id")
    private User createdBy;
    @Column(name = "is_read")
    private int isRead;
}
