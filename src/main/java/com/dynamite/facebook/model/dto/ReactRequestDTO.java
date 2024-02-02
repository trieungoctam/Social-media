package com.dynamite.facebook.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReactRequestDTO {
    private Long userId;
    private Long postId;
}
