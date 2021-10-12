package com.trio.pintree.roadmap.repository;

import com.trio.pintree.roadmap.domain.RoadMap;
import com.trio.pintree.roadmap.exception.NotFoundRoadMapException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
class RoadMapRepositoryTest {

    @Autowired
    private RoadMapRepository roadMapRepository;

    @Test
    @DisplayName("RoadMapRepository 저장 테스트")
    void itShouldSaveRoadMap() {
        //given
        RoadMap roadMap = RoadMap.from("제목1");

        //when
        RoadMap savedRoadMap = roadMapRepository.save(roadMap);
        RoadMap findRoadMap = roadMapRepository.findById(savedRoadMap.getId())
                .orElseThrow(NotFoundRoadMapException::new);

        //then
        assertThat(findRoadMap).isEqualTo(savedRoadMap);
    }

    @Test
    @DisplayName("RoadMapRepository 단일 조회 테스트")
    void itShouldFindRoadMapById() {
        //given
        RoadMap roadMap = RoadMap.from("제목1");
        int expectedSize = 1;

        //when
        roadMapRepository.save(roadMap);
        List<RoadMap> roadMapList = roadMapRepository.findAll();

        //then
        assertThat(roadMapList).hasSize(expectedSize);
    }
}
