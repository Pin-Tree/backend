package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Node;
import com.trio.pintree.login.dto.node.CreateCustomNodeRequest;
import com.trio.pintree.login.dto.node.CreateNodeRequest;
import com.trio.pintree.login.dto.node.CreateNodeResponse;
import com.trio.pintree.login.dto.node.CreateOfficialNodeRequest;
import com.trio.pintree.login.repository.NodeRepository;
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
