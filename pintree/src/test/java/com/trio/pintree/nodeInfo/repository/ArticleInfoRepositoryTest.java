package com.trio.pintree.nodeInfo.repository;

import com.trio.pintree.nodeInfo.domain.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ArticleInfoRepositoryTest {

    @Autowired
    private ArticleInfoRepository repository;

    @Test
    void save() throws Exception {
        ArticleInfo articleInfo = ArticleInfo.builder()
                                             .title("제목")
                                             .description("설명")
                                             .date(LocalDateTime.now())
                                             .wishCount(0)
                                             .shortcutUrl("shortUrl")
                                             .platform("inflearn")
                                             .writer("writer").build();

        repository.save(articleInfo);
        ArticleInfo findInfo = repository.findById(1L).orElseThrow(Exception::new);

        assertThat(findInfo).isEqualTo(articleInfo);
    }

}