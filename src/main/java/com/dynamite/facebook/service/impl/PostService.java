package com.dynamite.facebook.service.impl;

import com.dynamite.facebook.repository.PostRepository;
import com.dynamite.facebook.service.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService implements IPostService {
    private final PostRepository postRepository;

}
