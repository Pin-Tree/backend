package com.trio.pintree.node.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class CreateNodeRequest {

    @JsonProperty("node_name")
    private String name;

    @JsonProperty("parent_id")
    private Long parentId;

    @JsonProperty("is_main")
    private boolean isMain;

    @JsonProperty("is_up")
    private boolean isUp;

    @JsonProperty("index")
    private long index;


}
