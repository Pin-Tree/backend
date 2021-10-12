package com.trio.pintree.roadmap.service;

import com.trio.pintree.roadmap.domain.RoadMap;
import com.trio.pintree.roadmap.dto.RoadMapDto;
import com.trio.pintree.roadmap.dto.RoadMapLookUpResponse;
import com.trio.pintree.roadmap.exception.NotFoundRoadMapException;
import com.trio.pintree.roadmap.repository.RoadMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RoadMapService {

    private final RoadMapRepository roadMapRepository;

    public boolean setRoadMapPublic(RoadMapDto roadMapDto) {
        RoadMap roadMap = roadMapRepository.findById(roadMapDto.getRoadMapId())
                .orElseThrow(NotFoundRoadMapException::new);
        roadMap.setPublic();
        return roadMap.isPublic();
    }

    public boolean setRoadMapPrivate(RoadMapDto roadMapDto) {
        RoadMap roadMap = roadMapRepository.findById(roadMapDto.getRoadMapId())
                .orElseThrow(NotFoundRoadMapException::new);
        roadMap.setPrivate();
        return roadMap.isPublic();
    }

    public RoadMapLookUpResponse findRoadMapById(Long roadMapId) {
        RoadMap roadMap = roadMapRepository.findById(roadMapId)
                .orElseThrow(NotFoundRoadMapException::new);
        return RoadMapLookUpResponse.from(roadMap);
    }
}
