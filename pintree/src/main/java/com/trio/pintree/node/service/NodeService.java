package com.trio.pintree.node.service;

import com.trio.pintree.node.domain.Node;
import com.trio.pintree.node.dto.CreateCustomNodeRequest;
import com.trio.pintree.node.dto.CreateNodeRequest;
import com.trio.pintree.node.dto.CreateNodeResponse;
import com.trio.pintree.node.dto.CreateOfficialNodeRequest;
import com.trio.pintree.node.repository.NodeRepository;
import com.trio.pintree.roadmap.domain.RoadMap;
import com.trio.pintree.roadmap.exception.NotFoundRoadMapException;
import com.trio.pintree.roadmap.repository.RoadMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NodeService {
    static final boolean OFFICIAL = true;
    static final boolean CUSTOM = false;

    private final NodeRepository nodeRepository;
    private final RoadMapRepository roadMapRepository;

    // TODO : 노드 디테일 객체 추가 로직
    public CreateNodeResponse createCustomNode(Long roadmapId, CreateCustomNodeRequest createRequest) {
        Node newOfficialNode = createNode(roadmapId, createRequest, OFFICIAL);
        return CreateNodeResponse.from(newOfficialNode);
    }

    // TODO : 노드 디테일 객체 추가 로직
    public CreateNodeResponse createOfficialNode(Long roadmapId, CreateOfficialNodeRequest createRequest) {
        Node newCustomNode = createNode(roadmapId, createRequest, CUSTOM);
        return CreateNodeResponse.from(newCustomNode);
    }

    private Node createNode(Long roadmapId,CreateNodeRequest createRequest, boolean isOfficial) {
        RoadMap roadMap = roadMapRepository.findById(roadmapId).orElseThrow(NotFoundRoadMapException::new);

        if (createRequest.isMain()) {
            Node mainNode = Node.createMainNode(
                    roadMap,
                    createRequest.getName(),
                    createRequest.getIndex(),
                    isOfficial
            );
            return nodeRepository.save(mainNode);
        }

        Node parent = nodeRepository.getById(createRequest.getParentId());
        Node nonMainNode = Node.createNonMainNode(
                roadMap,
                createRequest.getName(),
                createRequest.getIndex(),
                isOfficial,
                createRequest.isUp(),
                parent
        );
        return nodeRepository.save(nonMainNode);
    }
}
