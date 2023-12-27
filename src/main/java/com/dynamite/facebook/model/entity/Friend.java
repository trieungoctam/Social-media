package com.dynamite.facebook.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "friend")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Friend {
    @Id
    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User senderId;
    @Id
    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private User receiverId;
    @Column(name = "is_friend")
    private int isFriend;
}
