package com.trio.pintree.nodeInfo.domain;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("book")
public class BookInfo extends OfficialNodeInfo{
    private String publisher;
    private String author;
    private Integer price;
}
