package com.trio.pintree.roadmap.controller;

import com.trio.pintree.roadmap.dto.RoadMapLookUpResponse;
import com.trio.pintree.roadmap.service.RoadMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roadmap")
public class RoadMapController {

    private final RoadMapService roadMapService;

    @GetMapping("/{roadMapId}")
    public RoadMapLookUpResponse getRoadMap(@PathVariable Long roadMapId) {
        return roadMapService.findRoadMapById(roadMapId);
    }
}
