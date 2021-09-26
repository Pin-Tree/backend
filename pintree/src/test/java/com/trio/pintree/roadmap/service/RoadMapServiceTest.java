package com.trio.pintree.roadmap.service;

import com.trio.pintree.roadmap.domain.RoadMap;
import com.trio.pintree.roadmap.dto.RoadMapDto;
import com.trio.pintree.roadmap.repository.RoadMapRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class RoadMapServiceTest {

    private RoadMapService roadMapService;
    private RoadMapRepository roadMapRepository;

    @BeforeEach
    void setUp() {
        roadMapRepository = mock(RoadMapRepository.class);
        roadMapService = new RoadMapService(roadMapRepository);
    }

    @Test
    @DisplayName("공개여부를 공개로 변경할 수 있다.")
    void itShouldModifyToPublic() {
        //given
        RoadMap roadMap = RoadMap.from("제목1");
        RoadMapDto roadMapDto = RoadMapDto.from(1L);
        when(roadMapRepository.findById(roadMapDto.getRoadMapId())).thenReturn(Optional.of(roadMap));

        //when
        boolean result = roadMapService.setRoadMapPublic(roadMapDto);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("공개여부를 비공개로 변경할 수 있다.")
    void itShouldModifyToPrivate() {
        //given
        RoadMap roadMap = RoadMap.from("제목1");
        RoadMapDto roadMapDto = RoadMapDto.from(1L);
        when(roadMapRepository.findById(roadMapDto.getRoadMapId())).thenReturn(Optional.of(roadMap));

        //when
        boolean result = roadMapService.setRoadMapPrivate(roadMapDto);

        //then
        assertThat(result).isFalse();
    }
}
