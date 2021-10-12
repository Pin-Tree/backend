package com.trio.pintree.nodeInfo.repository;

import com.trio.pintree.nodeInfo.domain.LectureInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class LectureInfoRepositoryTest {

    @Autowired
    private LectureInfoRepository lectureInfoRepository;

    @Test
    void save() throws Exception {
        LectureInfo lectureInfo = LectureInfo.builder()
                                             .nodeId(2L)
                                             .title("제목")
                                             .description("설명")
                                             .date(LocalDateTime.now())
                                             .thumbnail("thumb")
                                             .wishCount(0)
                                             .shortcutUrl("url")
                                             .supplier("supplier")
                                             .instructor("instructor")
                                             .price(1000)
                                             .build();

        lectureInfoRepository.save(lectureInfo);
        LectureInfo findInfo = lectureInfoRepository.findById(1L).orElseThrow(Exception::new);

        assertThat(findInfo).isEqualTo(lectureInfo);
    }

}