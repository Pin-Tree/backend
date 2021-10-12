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

    public ArticleInfo(Long nodeId, String title, String description, LocalDateTime date, String thumbnail, Integer wishCount, String shortcutUrl, String platform, String writer) {
        super(nodeId, title, description, date, thumbnail, wishCount, shortcutUrl);
        this.platform = platform;
        this.writer = writer;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long nodeId;
        private String title;
        private String description;
        private LocalDateTime date;

        private String thumbnail;
        private Integer wishCount;
        private String shortcutUrl;

        private String platform;
        private String writer;

        public Builder nodeId(Long nodeId) {
            this.nodeId = nodeId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder date(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public Builder thumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder wishCount(Integer wishCount) {
            this.wishCount = wishCount;
            return this;
        }

        public Builder shortcutUrl(String shortcutUrl) {
            this.shortcutUrl = shortcutUrl;
            return this;
        }

        public Builder platform(String platform) {
            this.platform = platform;
            return this;
        }

        public Builder writer(String writer) {
            this.writer = writer;
            return this;
        }

        public ArticleInfo build() {
            return new ArticleInfo(nodeId, title, description, date, thumbnail, wishCount, shortcutUrl, platform, writer);
        }

    }
}
