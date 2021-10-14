package com.trio.pintree.nodeInfo.domain;

import com.trio.pintree.node.domain.Node;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@DiscriminatorValue("book")
@ToString
public class BookInfo extends OfficialNodeInfo {

    private String publisher;

    private String author;

    private Integer price;

    public BookInfo(Node node, String title, String description, LocalDateTime date, String thumbnail, Integer wishCount, String shortcutUrl, String publisher, String author, Integer price) {

        super(node, title, description, date, thumbnail, wishCount, shortcutUrl);

        this.publisher = publisher;
        this.author = author;
        this.price = price;
    }

    public BookInfo() {

    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Node node;
        private String title;
        private String description;
        private LocalDateTime date;

        private String thumbnail;
        private Integer wishCount;
        private String shortcutUrl;

        private String publisher;
        private String author;
        private Integer price;


        public Builder node(Node node) {
            this.node = node;
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

        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder price(Integer price) {
            this.price = price;
            return this;
        }

        public BookInfo build() {
            return new BookInfo(node, title, description, date, thumbnail, wishCount, shortcutUrl, publisher, author, price);
        }

    }
}
