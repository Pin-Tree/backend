package com.trio.pintree.roadmap.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoadMap {
    @Id
    @GeneratedValue
    @Column(name = "ROADMAP_ID")
    private Long id;

    @NotBlank
    @Column(name = "ROADMAP_TITLE")
    private String title;

    public RoadMap(String title) {
        this.title = title;
    }
}
