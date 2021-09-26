package com.trio.pintree.nodeInfo.domain;

import lombok.Getter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("official")
@DiscriminatorColumn(name = "info_type")
public abstract class OfficialNodeInfo extends NodeInfo {
    private String thumbnail;
    private Integer wishCount;
    private String shortcutUrl;
}
