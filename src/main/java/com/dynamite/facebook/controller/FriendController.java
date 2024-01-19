package com.dynamite.facebook.controller;

import com.dynamite.facebook.model.dto.FriendDTO;
import com.dynamite.facebook.model.entity.Friend;
import com.dynamite.facebook.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/friend")
@CrossOrigin(origins = "*")
public class FriendController {
    @Autowired
    private IFriendService friendService;
    @GetMapping("{id}")
    public List<Friend> findFriendById(@PathVariable int id) {
        return friendService.findAllFriendById(id);
    }
    @PostMapping("/")
    public Friend save(@RequestBody FriendDTO friend) {
        return friendService.save(friend);
    }
    @PutMapping("/")
    public Friend updateIsFriend(@RequestBody Friend friend) {
        return friendService.updateIsFriend(friend.getSenderId().getId(), friend.getReceiverId().getId(), friend.getIsFriend());
    }
}
