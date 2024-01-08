package com.dynamite.facebook.repository;

import com.dynamite.facebook.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUser_Id(Long userId);
}
