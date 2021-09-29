package com.trio.pintree.nodeInfo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@DiscriminatorValue("lecture")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LectureInfo extends OfficialNodeInfo {

    private String supplier;
    private String instructor;
    private Integer price;

    public LectureInfo(Long nodeId, String title, String description, LocalDateTime date, String thumbnail, Integer wishCount, String shortcutUrl, String supplier, String instructor, Integer price) {
        super(nodeId, title, description, date, thumbnail, wishCount, shortcutUrl);
        this.supplier = supplier;
        this.instructor = instructor;
        this.price = price;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private Long nodeId;
        private String title;
        private String description;
        private LocalDateTime date;

        private String thumbnail;
        private Integer wishCount;
        private String shortcutUrl;

        private String supplier;
        private String instructor;
        private Integer price;

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

        Builder supplier(String supplier) {
            this.supplier = supplier;
            return this;
        }

        Builder instructor(String instructor) {
            this.instructor = instructor;
            return this;
        }

        Builder price(Integer price) {
            this.price = price;
            return this;
        }

        LectureInfo build() {
            return new LectureInfo(nodeId, title, description, date, thumbnail, wishCount, shortcutUrl, supplier, instructor, price);
        }

    }
}
