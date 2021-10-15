package com.trio.pintree.roadmap.controller;

import com.trio.pintree.roadmap.dto.CreateRoadMapRequest;
import com.trio.pintree.roadmap.dto.CreateRoadMapResponse;
import com.trio.pintree.roadmap.dto.RoadMapLookUpResponse;
import com.trio.pintree.roadmap.service.RoadMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roadmap")
public class RoadMapController {

    private final RoadMapService roadMapService;

    @GetMapping("/{roadMapId}")
    public RoadMapLookUpResponse getRoadMap(@PathVariable Long roadMapId) {
        return roadMapService.findRoadMapById(roadMapId);
    }

    @PostMapping
    public ResponseEntity<CreateRoadMapResponse> createRoadMap(@RequestBody CreateRoadMapRequest createRoadMapRequest) {
        CreateRoadMapResponse createRoadMapResponse = roadMapService.createRoadMap(createRoadMapRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRoadMapResponse);
    }

}
