package com.trio.pintree.roadmap.dto;

import com.trio.pintree.node.domain.Node;
import com.trio.pintree.roadmap.domain.RoadMap;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateRoadMapResponse {

    private Long roadmapId;

    private String roadmapTitle;

    private boolean isPublic;

    public static CreateRoadMapResponse from(RoadMap roadMap) {
        return new CreateRoadMapResponse(
                roadMap.getId(),
                roadMap.getTitle(),
                roadMap.isPublic()
        );
    }
}
