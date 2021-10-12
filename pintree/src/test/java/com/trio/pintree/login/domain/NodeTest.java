package com.trio.pintree.login.domain;

import com.trio.pintree.node.repository.NodeRepository;
import com.trio.pintree.node.domain.Node;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class NodeTest {

    @Autowired
    private NodeRepository repository;

    @Test
    void 메인노드를_생성할_수_있다() throws Exception {
        final String name = "HTML";
        final long index = 100L;
        final boolean isOfficial = false;

        Node node = Node.createMainNode(name, index, isOfficial);

        repository.save(node);

        Node savedNode = repository.getById(node.getId());
        assertThat(savedNode).isEqualTo(node);
    }
    
    @Test
    void 자식노드를_생성할_수_있다() throws Exception {
        final String name = "HTML";
        final boolean isUp = true;
        final boolean isDown = false;
        final long index = 100L;
        final boolean isOfficial = false;

        Node parent = Node.createMainNode(name, index, isOfficial);
        Node firstChild = Node.createNonMainNode(name, index, isOfficial, isUp, parent);
        Node secondChild = Node.createNonMainNode(name, index, isOfficial, isDown, parent);

        repository.save(parent);

        Node savedNode = repository.getById(parent.getId());
        assertThat(savedNode.getChildren()).hasSize(2);
    }

}
