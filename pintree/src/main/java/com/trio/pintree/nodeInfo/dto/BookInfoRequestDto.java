package com.trio.pintree.nodeInfo.dto;

import com.trio.pintree.nodeInfo.domain.BookInfo;
import com.trio.pintree.nodeInfo.domain.OfficialCategory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class BookInfoRequestDto {

    private final String title;

    private final String description;

    private final LocalDateTime date;

    private final String thumbnail;

    private final String shortcutUrl;

    private final String publisher;

    private final String author;

    private final Integer price;

    public static BookInfo of(OfficialCategory officialCategory, BookInfoRequestDto bookInfoRequestDto) {
        return BookInfo.builder()
                       .officialCategory(officialCategory)
                       .title(bookInfoRequestDto.title)
                       .description(bookInfoRequestDto.description)
                       .date(bookInfoRequestDto.date)
                       .thumbnail(bookInfoRequestDto.thumbnail)
                       .shortcutUrl(bookInfoRequestDto.shortcutUrl)
                       .publisher(bookInfoRequestDto.publisher)
                       .author(bookInfoRequestDto.author)
                       .price(bookInfoRequestDto.price)
                       .build();
    }

}
