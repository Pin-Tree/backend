package com.trio.pintree.nodeInfo.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OfficialNodeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoId;

    //TODO. Node 객체로 변경해야함. (연관관계 맺을 때 생각)
    //TODO. BookInfo... 등 자식 클래스에서 nodeId를 많이 사용하고 있으므로 변경할 때 참고할 것


    private String title;

    private String description;

    private LocalDateTime date;

    private String thumbnail;

    private Integer wishCount;

    private String shortcutUrl;

    @ManyToOne
    @JoinColumn(name = "official_category_id")
    private OfficialCategory officialCategory;

    public OfficialNodeInfo(OfficialCategory officialCategory,
                            String title,
                            String description,
                            LocalDateTime date,
                            String thumbnail,
                            Integer wishCount,
                            String shortcutUrl) {
        this.officialCategory = officialCategory;
        this.title = title;
        this.description = description;
        this.date = date;
        this.thumbnail = thumbnail;
        this.wishCount = wishCount;
        this.shortcutUrl = shortcutUrl;
    }

    public OfficialNodeInfo() {

    }
}
