package com.trio.pintree.roadmap.dto;

import com.trio.pintree.node.dto.LookupNodeResponse;
import com.trio.pintree.roadmap.domain.RoadMap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RoadMapLookUpResponse {

    private final Long id;

    private final String title;

    private final boolean isPublic;

    private final List<LookupNodeResponse> nodes;

    public static RoadMapLookUpResponse from(RoadMap roadMap, List<LookupNodeResponse> nodes) {
        return new RoadMapLookUpResponse(roadMap.getId(), roadMap.getTitle(), roadMap.isPublic(),  nodes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadMapLookUpResponse that = (RoadMapLookUpResponse) o;
        return isPublic() == that.isPublic()
                && getId().equals(that.getId())
                && getTitle().equals(that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), isPublic());
    }
}
