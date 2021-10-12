package com.trio.pintree.nodeInfo.dto;

import com.trio.pintree.nodeInfo.domain.BookInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class BookInfoDto {

    private final Long infoId;

    private final String title;

    private final String description;

    private final LocalDateTime date;

    private final String thumbnail;

    private final Integer wishCount;

    private final String shortcutUrl;

    private final String publisher;

    private final String author;

    private final Integer price;

    public static BookInfoDto from(BookInfo bookInfo) {
        return new BookInfoDto(bookInfo.getInfoId(), bookInfo.getTitle(), bookInfo.getDescription(), bookInfo.getDate(), bookInfo.getThumbnail(), bookInfo.getWishCount(), bookInfo.getShortcutUrl(), bookInfo.getPublisher(), bookInfo.getAuthor(), bookInfo.getPrice());
    }
}
