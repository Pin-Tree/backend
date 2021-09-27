package com.trio.pintree.nodeInfo.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@DiscriminatorValue("custom")
public class CustomNodeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long infoId;

    Long nodeId;

    String title;

    String description;

    LocalDateTime date;
}
