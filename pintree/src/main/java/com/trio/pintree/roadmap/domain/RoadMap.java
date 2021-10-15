package com.trio.pintree.roadmap.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.trio.pintree.node.domain.Node;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

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
    private boolean isPublic = false;

    @JsonManagedReference
    @OneToMany(mappedBy = "roadMap", fetch = FetchType.LAZY)
    private List<Node> nodes = new ArrayList<>();


    private RoadMap(String title) {
        this.title = title;
    }

    public static RoadMap from(String title) {
        return new RoadMap(title);
    }

    private void setId(Long id) {
        this.id = id;
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
