package com.dynamite.facebook.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "m_group")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "banner_url")
    private String bannerUrl;
    @Column(name = "about")
    private String about;
}
