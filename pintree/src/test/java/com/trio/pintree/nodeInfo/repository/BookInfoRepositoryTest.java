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
        BookInfo bookInfo = new BookInfo(2L, "제목", "설명", LocalDateTime.now(), "thumb", 0, "url", "publisher", "author", 1000);
        bookInfoRepository.save(bookInfo);

        BookInfo findInfo = bookInfoRepository.findById(1L).orElseThrow(Exception::new);
        assertThat(findInfo).isEqualTo(bookInfo);
    }
}