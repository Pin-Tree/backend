package com.trio.pintree.nodeInfo.repository;

import com.trio.pintree.nodeInfo.domain.OfficialNodeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface OfficialNodeInfoRepository<T extends OfficialNodeInfo> extends JpaRepository<T, Long> {
    List<T> findByOfficialCategoryId(Long officialCategoryId);

    Optional<T> findByOfficialCategoryIdAndInfoId(Long officialCategoryId, Long infoId);

    @Transactional
    void deleteByInfoId(Long infoId);
}
