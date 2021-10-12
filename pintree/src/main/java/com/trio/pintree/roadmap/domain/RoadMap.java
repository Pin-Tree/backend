package com.trio.pintree.roadmap.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Table(name = "roadmap")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoadMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roadmap_id")
    private Long id;

    @NotBlank
    @Column(name = "roadmap_title")
    private String title;

    private double progress = 0.0;

    private String shareUrl = "";

    private RoadMap(String title) {
        this.title = title;
    }

    public static RoadMap from(String title) {
        return new RoadMap(title);
    }
}
