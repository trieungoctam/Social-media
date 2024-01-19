package com.dynamite.facebook.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDTO {
    private Long userId;
    private Long postId;
    private Timestamp createdAt;
    private Long reactCount;
    private int isRoot;
    private Long parentId;
    private String resources;
    private String content;
}
