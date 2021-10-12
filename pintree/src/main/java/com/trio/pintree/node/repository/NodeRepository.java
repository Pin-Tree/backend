package com.trio.pintree.node.repository;

import com.trio.pintree.node.domain.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node, Long> {
}
