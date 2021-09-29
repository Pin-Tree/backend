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

    //TODO. Node 객체로 변경해야함. (연관관계 맺을 때 생각)
    Long nodeId;

    String title;

    String description;

    LocalDateTime date;
}
