package com.trio.pintree.roadmap.repository;

import com.trio.pintree.roadmap.domain.RoadMap;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoadMapRepository extends CrudRepository<RoadMap, Long> {
    List<RoadMap> findAll();
}

