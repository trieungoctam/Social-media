package com.dynamite.facebook.repository;

import com.dynamite.facebook.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query(
            "SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END " +
            "FROM User s WHERE s.username = ?1"
    )
    Boolean existsByUsername(String username);
    @Query(
            "SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END " +
                    "FROM User s WHERE s.email = ?1"
    )
    Boolean existsByEmail(String email);
    Optional<User> findByUsernameAndPassword(String username, String password);

}
