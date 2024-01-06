package com.dynamite.facebook.repository;

import com.dynamite.facebook.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
