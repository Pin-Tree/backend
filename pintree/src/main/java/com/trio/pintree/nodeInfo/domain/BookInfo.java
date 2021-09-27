package com.trio.pintree.nodeInfo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@DiscriminatorValue("book")
@ToString
public class BookInfo extends OfficialNodeInfo {

    private String publisher;

    private String author;

    private Integer price;

    public BookInfo(Long nodeId, String title, String description, LocalDateTime date, String thumbnail, Integer wishCount, String shortcutUrl, String publisher, String author, Integer price) {

        super(nodeId, title, description, date, thumbnail, wishCount, shortcutUrl);

        this.publisher = publisher;
        this.author = author;
        this.price = price;
    }

    public BookInfo() {

    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        public Long nodeId;
        public String title;
        public String description;
        public LocalDateTime date;

        public String thumbnail;
        public Integer wishCount;
        public String shortcutUrl;

        public String publisher;
        public String author;
        public Integer price;

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

        Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        Builder author(String author) {
            this.author = author;
            return this;
        }

        Builder price(Integer price) {
            this.price = price;
            return this;
        }

        BookInfo build() {
            return new BookInfo(nodeId, title, description, date, thumbnail, wishCount, shortcutUrl, publisher, author, price);
        }

    }
}
