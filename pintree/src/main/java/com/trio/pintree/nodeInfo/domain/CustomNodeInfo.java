package com.trio.pintree.nodeInfo.domain;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("custom")
public class CustomNodeInfo extends NodeInfo {
}
