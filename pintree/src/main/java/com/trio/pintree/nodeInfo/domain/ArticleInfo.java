package com.trio.pintree.nodeInfo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@DiscriminatorValue("article")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleInfo extends OfficialNodeInfo {
    private String platform;
    private String writer;

    public ArticleInfo(Long infoId, Long nodeId, String title, String description, LocalDateTime date, String thumbnail, Integer wishCount, String shortcutUrl, String platform, String writer) {
        this.infoId = infoId;
        this.nodeId = nodeId;
        this.title = title;
        this.description = description;
        this.date = date;

        this.thumbnail = thumbnail;
        this.wishCount = wishCount;
        this.shortcutUrl = shortcutUrl;

        this.platform = platform;
        this.writer = writer;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private Long infoId;
        private Long nodeId;
        private String title;
        private String description;
        private LocalDateTime date;

        private String thumbnail;
        private Integer wishCount;
        private String shortcutUrl;

        private String platform;
        private String writer;

        Builder infoId(Long infoId) {
            this.infoId = infoId;
            return this;
        }

        Builder nodeId(Long nodeId) {
            this.nodeId = nodeId;
            return this;
        }

        Builder title(String title) {
            this.title = title;
            return this;
        }

        Builder description(String description) {
            this.description = description;
            return this;
        }

        Builder date(LocalDateTime date) {
            this.date = date;
            return this;
        }

        Builder thumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        Builder wishCount(Integer wishCount) {
            this.wishCount = wishCount;
            return this;
        }

        Builder shortcutUrl(String shortcutUrl) {
            this.shortcutUrl = shortcutUrl;
            return this;
        }

        Builder platform(String platform) {
            this.platform = platform;
            return this;
        }

        Builder writer(String writer) {
            this.writer = writer;
            return this;
        }

        ArticleInfo build() {
            return new ArticleInfo(infoId, nodeId, title, description, date, thumbnail, wishCount, shortcutUrl, platform, writer);
        }

    }
}
