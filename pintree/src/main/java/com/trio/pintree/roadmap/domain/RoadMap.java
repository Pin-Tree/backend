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

    @Column(name = "is_public")
    private Boolean isPublic = false;

    private RoadMap(String title) {
        this.title = title;
    }

    public static RoadMap from(String title) {
        return new RoadMap(title);
    }

    public void setPublic() {
        this.isPublic = true;
    }

    public void setPrivate() {
        this.isPublic = false;
    }

    public boolean isPublic() {
        return isPublic;
    }
}
