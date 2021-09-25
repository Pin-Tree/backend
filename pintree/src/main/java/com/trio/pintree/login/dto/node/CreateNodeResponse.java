package com.trio.pintree.login.dto.node;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trio.pintree.login.domain.Node;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CreateNodeResponse {

    @JsonProperty("node_id")
    private Long id;

    @JsonProperty("node_name")
    private String name;

    public static CreateNodeResponse from(Node createdNode) {
        final Long id = createdNode.getId();
        final String name = createdNode.getName();
        return new CreateNodeResponse(id, name);
    }

}
