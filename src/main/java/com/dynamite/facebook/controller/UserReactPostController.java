package com.dynamite.facebook.controller;

import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.dto.ReactDTO;
import com.dynamite.facebook.model.dto.ReactPostDTO;
import com.dynamite.facebook.model.dto.ReactRequestDTO;
import com.dynamite.facebook.model.entity.UserReactPost;
import com.dynamite.facebook.service.IUserReactPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/react/")
@CrossOrigin(origins = "*")
public class UserReactPostController {

    @Autowired
    private IUserReactPostService userReactPostService;
    @PostMapping("/add")
    public void addReact(@RequestBody ReactDTO reactDTO) throws ResponseException {
        System.out.println(reactDTO);
        userReactPostService.addReact(reactDTO.getPostId(),reactDTO.getUserId(),reactDTO.getReactType());
    }
    @DeleteMapping("/delete")
    public void deleteReact(@RequestParam Long postId, @RequestParam Long userId) throws ResponseException {
        userReactPostService.removeReact(postId,userId);
    }

    @GetMapping("/{id}")
    public List<UserReactPost> findAllByPostId(@PathVariable("id") Long postId) {
        return userReactPostService.findAllByPost_Id(postId);
    }
}
