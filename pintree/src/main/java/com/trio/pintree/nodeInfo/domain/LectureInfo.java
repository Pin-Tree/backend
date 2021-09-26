package com.trio.pintree.nodeInfo.domain;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("lecture")
public class LectureInfo extends OfficialNodeInfo{
    private String supplier;
    private String instructor;
    private Integer price;
}
