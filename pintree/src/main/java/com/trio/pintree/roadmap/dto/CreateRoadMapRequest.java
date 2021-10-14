package com.trio.pintree.roadmap.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateRoadMapRequest {

    private String roadmapTitle;

}