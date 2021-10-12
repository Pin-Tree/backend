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
    private Long nodeId;

    private String title;

    private String description;

    private LocalDateTime date;

    private String thumbnail;

    private Integer wishCount;

    private String shortcutUrl;

    public OfficialNodeInfo(Long nodeId, String title, String description, LocalDateTime date, String thumbnail, Integer wishCount, String shortcutUrl) {
        this.nodeId = nodeId;
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
