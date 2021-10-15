package com.trio.pintree.node.dto;

import com.trio.pintree.node.domain.Node;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LookupNodeResponse {
    private Long id;
    private String name;
    private String memo;
    private boolean official;
    private boolean main;
    private boolean up;

    public static LookupNodeResponse from(Node node){
        return new LookupNodeResponse(node.getId(), node.getName(), node.getMemo(), node.isOfficial(), node.isMain(), node.isUp());
    }
}
