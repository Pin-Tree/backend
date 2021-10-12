package com.trio.pintree.nodeInfo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class BookInfosDto {
    private final List<BookInfoDto> bookInfoDtoList;

    public static BookInfosDto from(List<BookInfoDto> bookInfoDtoList) {
        return new BookInfosDto(bookInfoDtoList);
    }
}
