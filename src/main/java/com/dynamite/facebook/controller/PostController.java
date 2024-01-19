package com.dynamite.facebook.controller;

import com.dynamite.facebook.constant.ResponseValue;
import com.dynamite.facebook.exception.ResponseException;
import com.dynamite.facebook.model.dto.file.ResponseUploadFile;
import com.dynamite.facebook.model.dto.post.RequestPost;
import com.dynamite.facebook.model.dto.post.RequestPostUser;
import com.dynamite.facebook.model.dto.post.ResponsePost;
import com.dynamite.facebook.model.dto.user.UserDetailsImpl;
import com.dynamite.facebook.model.entity.Post;
import com.dynamite.facebook.service.IPostMapper;
import com.dynamite.facebook.service.impl.MinioStorageService;
import com.dynamite.facebook.service.impl.PostMapper;
import com.dynamite.facebook.service.impl.PostService;
import com.dynamite.facebook.util.LoadingCacheStore;
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
    @Autowired
    private LoadingCacheStore<Post> postLoadingCacheStore;
    @Autowired
    private IPostMapper IPostMapper;

    @PostMapping("/create")
    @Transactional
    public ResponsePost createPost(@RequestParam("file") MultipartFile file, @RequestParam("content") String content) throws ResponseException {
        ResponseUploadFile responseUploadFile = minioStorageService.uploadFile(file);
        if (responseUploadFile == null) {
            throw new ResponseException(ResponseValue.BAD_REQUEST);
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postService.createPost(userDetails.getId(), responseUploadFile.getUrlFile(), content);
        return postMapper.toResponsePost(post);
    }

    @GetMapping("/")
    public List<ResponsePost> getPostByUserId(@RequestBody RequestPostUser requestPostUser) {
        List<Post> posts = postService.getPostByUserId(requestPostUser.getUserId());
        return posts.stream().map(postMapper::toResponsePost).toList();
    }

    @GetMapping("/{id}")
    public ResponsePost getPostById(@PathVariable("id") Long id) throws ResponseException {
        try {
            Post post = postLoadingCacheStore.get(id);
            return postMapper.toResponsePost(post);
        }catch (Exception e) {
            throw new ResponseException(ResponseValue.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponsePost updatePost(@PathVariable("id") Long id, @RequestBody RequestPost requestPost) throws ResponseException {
        try {
            Post post = postService.updatePost(id, requestPost);
            postLoadingCacheStore.put(id, post);
            return postMapper.toResponsePost(post);
        }catch(Exception e) {
            throw new ResponseException(ResponseValue.NOT_FOUND);
        }
    }
}
