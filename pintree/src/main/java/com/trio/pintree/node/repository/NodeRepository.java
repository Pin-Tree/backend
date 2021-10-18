package com.trio.pintree.node.repository;

import com.trio.pintree.node.domain.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NodeRepository extends JpaRepository<Node, Long> {
    @Query(
            "SELECT n2 FROM Node n1 " +
                    "JOIN FETCH ParentChild pc " +
                    "ON n1.id = pc.parent.id " +
                    "JOIN FETCH Node n2 " +
                    "ON pc.child.id = n2.id " +
                    "WHERE n1.roadMap.id = :roadmapId"
    )
    List<Node> findAllByRoadMapId(@Param("roadmapId") Long roadmapId);
}
//    SELECT n2.* FROM Node n1
//    INNER JOIN Parent_Child pc
//    ON n1.node_id = pc.parent_id
//    INNER JOIN Node n2
//    ON pc.child_id = n2.node_id
//    WHERE n1.roadmap_id = 1;
