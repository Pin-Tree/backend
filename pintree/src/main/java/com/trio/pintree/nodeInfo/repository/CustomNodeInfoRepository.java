package com.trio.pintree.nodeInfo.repository;

import com.trio.pintree.nodeInfo.domain.CustomNodeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomNodeInfoRepository extends JpaRepository<CustomNodeInfo, Long> {
}
