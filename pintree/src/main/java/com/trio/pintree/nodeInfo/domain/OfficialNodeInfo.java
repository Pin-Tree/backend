package com.trio.pintree.nodeInfo.domain;

import lombok.Getter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Getter
@DiscriminatorColumn(name = "info_type")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OfficialNodeInfo extends NodeInfo {
    String thumbnail;
    Integer wishCount;
    String shortcutUrl;
}
