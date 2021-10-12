package com.trio.pintree.node.service;

import com.trio.pintree.node.domain.Node;
import com.trio.pintree.node.dto.CreateCustomNodeRequest;
import com.trio.pintree.node.dto.CreateNodeRequest;
import com.trio.pintree.node.dto.CreateNodeResponse;
import com.trio.pintree.node.dto.CreateOfficialNodeRequest;
import com.trio.pintree.node.repository.NodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NodeService {
    static final boolean OFFICIAL = true;
    static final boolean CUSTOM = false;

    private final NodeRepository nodeRepository;

    // TODO : 노드 디테일 객체 추가 로직
    public CreateNodeResponse createCustomNode(CreateCustomNodeRequest createRequest) {
        Node newOfficialNode = createNode(createRequest, OFFICIAL);
        return CreateNodeResponse.from(newOfficialNode);
    }

    // TODO : 노드 디테일 객체 추가 로직
    public CreateNodeResponse createOfficialNode(CreateOfficialNodeRequest createRequest) {
        Node newCustomNode = createNode(createRequest, CUSTOM);
        return CreateNodeResponse.from(newCustomNode);
    }

    private Node createNode(CreateNodeRequest createRequest, boolean isOfficial) {
        if (createRequest.isMain()) {
            return Node.createMainNode(createRequest.getName(), createRequest.getIndex(), isOfficial);
        }
        Node parent = nodeRepository.getById(createRequest.getParentId());
        return Node.createNonMainNode(
                createRequest.getName(),
                createRequest.getIndex(),
                isOfficial,
                createRequest.isUp(),
                parent
        );
    }
}
