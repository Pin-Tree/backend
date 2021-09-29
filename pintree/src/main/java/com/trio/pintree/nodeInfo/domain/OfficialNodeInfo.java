package com.trio.pintree.nodeInfo.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.DiscriminatorType.STRING;

@Entity
@Getter
@DiscriminatorColumn(name = "info_type", discriminatorType = STRING, length = 10)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OfficialNodeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoId;

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
