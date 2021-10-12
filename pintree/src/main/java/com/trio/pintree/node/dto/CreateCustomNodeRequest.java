package com.trio.pintree.node.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateCustomNodeRequest extends CreateNodeRequest {

    @JsonProperty("custom_info")
    private String customInfo;

    public CreateCustomNodeRequest(String name,
                                   Long parentId,
                                   boolean isMain,
                                   boolean isUp,
                                   long index,
                                   String customInfo) {
        super(name, parentId, isMain, isUp, index);
        this.customInfo = customInfo;
    }
}
