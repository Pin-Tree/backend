package com.trio.pintree.login.repository;

import com.trio.pintree.login.domain.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node, Long> {
}
