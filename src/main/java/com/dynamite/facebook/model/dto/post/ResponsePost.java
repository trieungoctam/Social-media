package com.dynamite.facebook.model.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponsePost {
    private Long id;
    private Long shareId;
    private Long userId;
    private String url;
    private String content;
    private Long reactCount;
    private int published;

}
