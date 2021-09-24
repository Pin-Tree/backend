package com.trio.pintree.roadmap.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Table(name = "ROADMAP")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoadMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROADMAP_ID")
    private Long id;

    @NotBlank
    @Column(name = "ROADMAP_TITLE")
    private String title;

    private RoadMap(String title) {
        this.title = title;
    }

    public static RoadMap create(String title) {
        return new RoadMap(title);
    }
}
