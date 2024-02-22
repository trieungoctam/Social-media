package com.dynamite.facebook.service.impl;

import com.dynamite.facebook.model.dto.FriendDTO;
import com.dynamite.facebook.model.entity.Friend;
import com.dynamite.facebook.model.entity.User;
import com.dynamite.facebook.repository.FriendRepository;
import com.dynamite.facebook.repository.UserRepository;
import com.dynamite.facebook.service.IFriendService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService implements IFriendService {
    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public Friend save(FriendDTO friendDTO) {
        User sender = userRepository.findById(friendDTO.getSenderId()).get();
        User receiver = userRepository.findById(friendDTO.getReceiverId()).get();
        Friend friend = new Friend();
        friend.setSenderId(sender);
        friend.setReceiverId(receiver);
        friend.setIsFriend(friendDTO.getIsFriend());
        return friendRepository.save(friend);
    }

    @Override
    public List<Friend> findAllFriendById(long id) {
        return friendRepository.findAllFriendById(id);
    }

    @Override
    public int checkFriend(long senderId, long receiverId) {
        return friendRepository.checkFriend(senderId, receiverId);
    }

    @Override
    public Friend updateIsFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public List<Friend> findAllNotAcceptedFriendById(long id) {
        return friendRepository.findAllNotAcceptedFriendById(id);
    }

    @Override
    public Integer checkIsFriend(long senderId, long receiverId) {
        return friendRepository.checkFriend(senderId, receiverId);
    }
}
