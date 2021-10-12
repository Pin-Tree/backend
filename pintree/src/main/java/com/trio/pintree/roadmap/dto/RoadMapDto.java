package com.trio.pintree.roadmap.dto;

import lombok.Getter;

@Getter
public class RoadMapDto {
    private Long roadMapId;

    public RoadMapDto(Long roadMapId) {
        this.roadMapId = roadMapId;
    }

    public static RoadMapDto from(Long roadMapId) {
        return new RoadMapDto(roadMapId);
    }
}
