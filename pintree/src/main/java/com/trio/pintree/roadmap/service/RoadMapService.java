package com.trio.pintree.roadmap.service;

import com.trio.pintree.node.domain.Node;
import com.trio.pintree.node.dto.LookupNodeResponse;
import com.trio.pintree.node.repository.NodeRepository;
import com.trio.pintree.roadmap.domain.RoadMap;
import com.trio.pintree.roadmap.dto.*;
import com.trio.pintree.roadmap.exception.NotFoundRoadMapException;
import com.trio.pintree.roadmap.repository.RoadMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RoadMapService {

    private final RoadMapRepository roadMapRepository;
    private final NodeRepository nodeRepository;

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

        List<Node> nodeList = nodeRepository.findAllByRoadMapId(roadMapId);
        List<LookupNodeResponse> nodeResponseList = nodeList.stream()
                .map(LookupNodeResponse::from)
                .collect(Collectors.toList());

        return RoadMapLookUpResponse.from(roadMap, nodeResponseList);
    }

    public CreateRoadMapResponse createRoadMap(CreateRoadMapRequest createRoadMapRequest) {
        RoadMap roadMap = RoadMap.from(createRoadMapRequest.getRoadmapTitle());
        roadMapRepository.save(roadMap);
        return CreateRoadMapResponse.from(roadMap);
    }
}
