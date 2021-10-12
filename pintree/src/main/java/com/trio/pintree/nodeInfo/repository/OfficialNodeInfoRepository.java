package com.trio.pintree.nodeInfo.repository;

import com.trio.pintree.nodeInfo.domain.OfficialNodeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficialNodeInfoRepository<T extends OfficialNodeInfo> extends JpaRepository<T, Long> {
    List<T> findByNodeId(Long nodeId);
    Optional<T> findByNodeIdAndInfoId(Long nodeId, Long infoId);

    @Transactional
    void deleteByInfoId(Long infoId);
}
