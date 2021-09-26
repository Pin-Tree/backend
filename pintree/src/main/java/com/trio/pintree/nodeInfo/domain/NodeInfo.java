package com.trio.pintree.nodeInfo.domain;


import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "node_type")
public abstract class NodeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoId;

    private Long nodeId;

    private String title;

    private String description;

    private LocalDateTime date;
}
