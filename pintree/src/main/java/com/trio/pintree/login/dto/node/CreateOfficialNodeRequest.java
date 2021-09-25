package com.trio.pintree.login.dto.node;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateOfficialNodeRequest {

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

    @JsonProperty("official_info_id")
    private Long officialInfoId;

}
