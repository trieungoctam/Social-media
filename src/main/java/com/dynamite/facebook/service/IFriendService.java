package com.dynamite.facebook.service;

import com.dynamite.facebook.model.dto.FriendDTO;
import com.dynamite.facebook.model.entity.Friend;

import java.util.List;

public interface IFriendService {

    Friend save(FriendDTO friendDTO);
    List<Friend> findAllFriendById(long id);
    int checkFriend(long senderId, long receiverId);
    Friend updateIsFriend(long senderId, long receiverId, int isFriend);
    List<Friend> findAllNotAcceptedFriendById(long id);
}
