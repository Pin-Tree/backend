package com.trio.pintree.nodeInfo.repository;

import com.trio.pintree.nodeInfo.domain.OfficialNodeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficialNodeInfoRepository<T extends OfficialNodeInfo> extends JpaRepository<T, Long> {

}
