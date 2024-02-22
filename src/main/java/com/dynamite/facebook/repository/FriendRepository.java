package com.dynamite.facebook.repository;

import com.dynamite.facebook.model.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
    @Query(value =
            "select distinct * from friend f where f.is_friend = 1 and f.sender_id = ?1"
            , nativeQuery = true)
    List<Friend> findAllFriendById(long id);
    @Query(value =
            "select f.is_friend top 1 from friend f where f.sender_id = ?1 and f.receiver_id = ?2 or f.sender_id = ?2 and f.receiver_id = ?1"
            , nativeQuery = true)
    int checkFriend(long senderId, long receiverId);
    @Query(value =
            "update friend f set f.is_friend = ?3 where f.sender_id = ?1 and f.receiver_id = ?2"
            , nativeQuery = true)
    Friend updateIsFriend(long senderId, long receiverId, int isFriend);
    @Query(value =
            "select distinct * from friend f where f.is_friend = 0 and f.receiver_id = ?1"
            , nativeQuery = true)
    List<Friend> findAllNotAcceptedFriendById(long id);
}
