package com.dynamite.facebook.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FriendDTO {
    private Long senderId;
    private Long receiverId;
    private int isFriend;
}
