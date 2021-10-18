package com.trio.pintree.node.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateOfficialNodeRequest extends CreateNodeRequest {

    @JsonProperty("official_info_id")
    private Long officialInfoId;

    public CreateOfficialNodeRequest(String name,
                                     Long parentId,
                                     boolean isMain,
                                     boolean isUp,
                                     long index,
                                     Long officialInfoId) {
        super(name, parentId, isMain, isUp, index);
        this.officialInfoId = officialInfoId;
    }
}
