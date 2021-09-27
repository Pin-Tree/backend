package com.trio.pintree.roadmap.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RoadMapLookUpRequest {
    private final Long roadMapId;
}
