package com.dynamite.facebook.model.dto.post;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestPost {
    private Long id;
    private String resources;
    private String content;
    private int published;
}
