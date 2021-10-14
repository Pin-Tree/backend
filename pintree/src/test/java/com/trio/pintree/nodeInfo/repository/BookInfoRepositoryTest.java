package com.trio.pintree.nodeInfo.repository;

import com.trio.pintree.nodeInfo.domain.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BookInfoRepositoryTest {

    @Autowired
    private BookInfoRepository bookInfoRepository;

    @Test
    void save() throws Exception {
        BookInfo bookInfo = BookInfo.builder()
                                    .title("제목")
                                    .description("설명")
                                    .date(LocalDateTime.now())
                                    .thumbnail("thumb")
                                    .wishCount(0)
                                    .shortcutUrl("url")
                                    .publisher("publisher")
                                    .author("author")
                                    .price(1000)
                                    .build();

        bookInfoRepository.save(bookInfo);
        BookInfo findInfo = bookInfoRepository.findById(1L).orElseThrow(Exception::new);

        assertThat(findInfo).isEqualTo(bookInfo);
    }
}