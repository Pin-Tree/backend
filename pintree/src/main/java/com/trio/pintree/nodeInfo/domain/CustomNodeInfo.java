package com.trio.pintree.nodeInfo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomNodeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoId;

    //TODO. Node 객체로 변경해야함. (연관관계 맺을 때 생각)
    private Long nodeId;

    private String title;

    private String description;

    private LocalDateTime date;

    public static Builder builder() {
        return new Builder();
    }

    public CustomNodeInfo(Long nodeId, String title, String description, LocalDateTime date) {
        this.nodeId = nodeId;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public static class Builder {
        private Long nodeId;
        private String title;
        private String description;
        private LocalDateTime date;


        public Builder nodeId(Long nodeId) {
            this.nodeId = nodeId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder date(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public CustomNodeInfo build() {
            return new CustomNodeInfo(nodeId, title, description, date);
        }
    }
}
