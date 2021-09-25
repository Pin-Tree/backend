package com.trio.pintree.login.controller;

import com.trio.pintree.login.dto.node.CreateCustomNodeRequest;
import com.trio.pintree.login.dto.node.CreateNodeResponse;
import com.trio.pintree.login.dto.node.CreateOfficialNodeRequest;
import com.trio.pintree.login.service.NodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/node")
public class NodeController {

    private final NodeService nodeService;

    @PostMapping("/official")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CreateNodeResponse> createOfficialNode(@RequestBody CreateOfficialNodeRequest createRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(nodeService.createOfficialNode(createRequest));
    }

    @PostMapping("/custom")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CreateNodeResponse> createCustomNode(@RequestBody CreateCustomNodeRequest createRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(nodeService.createCustomNode(createRequest));
    }



}
