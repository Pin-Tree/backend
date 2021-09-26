package com.trio.pintree.nodeInfo.domain;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("article")
public class ArticleInfo extends OfficialNodeInfo{
    private String platform;
    private String writer;
}
