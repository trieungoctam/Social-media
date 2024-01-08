package com.dynamite.facebook.controller;

import com.dynamite.facebook.model.dto.file.ResponseUploadFile;
import com.dynamite.facebook.model.dto.post.ResponsePost;
import com.dynamite.facebook.model.dto.user.UserDetailsImpl;
import com.dynamite.facebook.model.entity.Post;
import com.dynamite.facebook.service.impl.MinioStorageService;
import com.dynamite.facebook.service.impl.PostMapper;
import com.dynamite.facebook.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private MinioStorageService minioStorageService;
    @Autowired
    private PostService postService;
    @Autowired
    private PostMapper postMapper;

    @PostMapping("/create")
    @Transactional
    public ResponsePost createPost(@RequestParam("file") MultipartFile file, @RequestParam("content") String content) {
        ResponseUploadFile responseUploadFile = minioStorageService.uploadFile(file);
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postService.createPost(userDetails.getId(), responseUploadFile.getUrlFile(), content);
        return postMapper.toResponsePost(post);
    }

    @GetMapping("/{id}")
    public List<ResponsePost> getPostById(@PathVariable("id") Long id) {
        List<Post> posts = postService.getPostByUserId(id);
        return posts.stream().map(postMapper::toResponsePost).toList();
    }
}
