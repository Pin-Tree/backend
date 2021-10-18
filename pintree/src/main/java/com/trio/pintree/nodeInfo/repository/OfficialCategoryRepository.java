package com.trio.pintree.nodeInfo.repository;

import com.trio.pintree.nodeInfo.domain.OfficialCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficialCategoryRepository extends JpaRepository<OfficialCategory, Long> {
}
