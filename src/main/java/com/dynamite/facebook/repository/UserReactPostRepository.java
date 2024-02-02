package com.dynamite.facebook.repository;

import com.dynamite.facebook.model.entity.UserReactPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReactPostRepository extends JpaRepository<UserReactPost, Long> {
    @Query("SELECT u FROM UserReactPost u WHERE u.post.id = ?1 AND u.user.id = ?2")
    UserReactPost findByPost_IdAndUser_Id(Long postId, Long userId);

    void deleteById(Long id);

    @Query("SELECT urp FROM UserReactPost urp WHERE urp.post.id = ?1")
    List<UserReactPost> findAllByPost_Id(Long postId);
}
