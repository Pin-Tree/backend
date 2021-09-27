package com.trio.pintree.nodeInfo.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class NodeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long infoId;

    Long nodeId;

    String title;

    String description;

    LocalDateTime date;
}