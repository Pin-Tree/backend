package com.trio.pintree.login.domain;

import com.trio.pintree.login.repository.NodeRepository;
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
        boolean isUp = true;
        long index = 100L;
        boolean isOfficial = false;

        Node node = Node.createMainNode(isUp, index, isOfficial);

        repository.save(node);

        Node savedNode = repository.getById(node.getId());
        assertThat(savedNode).isEqualTo(node);
    }
    
    @Test
    void 자식노드를_생성할_수_있다() throws Exception {
        boolean isUp = true;
        boolean isDown = false;
        long index = 100L;
        boolean isOfficial = false;

        Node parent = Node.createMainNode(isUp, index, isOfficial);
        Node firstChild = Node.createNonMainNode(parent, isUp, index, isOfficial);
        Node secondChild = Node.createNonMainNode(parent, isDown, index, isOfficial);

        repository.save(parent);

        Node savedNode = repository.getById(parent.getId());
        assertThat(savedNode.getChildren()).hasSize(2);
    }

}
