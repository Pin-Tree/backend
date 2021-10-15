package com.trio.pintree.node.controller;

import com.trio.pintree.node.dto.CreateCustomNodeRequest;
import com.trio.pintree.node.dto.CreateNodeResponse;
import com.trio.pintree.node.dto.CreateOfficialNodeRequest;
import com.trio.pintree.node.service.NodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roadmaps/{roadmapId}/nodes")
public class NodeController {

    private final NodeService nodeService;

    @PostMapping("/official")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CreateNodeResponse> createOfficialNode(
            @PathVariable Long roadmapId,
            @RequestBody CreateOfficialNodeRequest createRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(nodeService.createOfficialNode(roadmapId, createRequest));
    }

    @PostMapping("/custom")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CreateNodeResponse> createCustomNode(
            @PathVariable Long roadmapId,
            @RequestBody CreateCustomNodeRequest createRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(nodeService.createCustomNode(roadmapId, createRequest));
    }

}
