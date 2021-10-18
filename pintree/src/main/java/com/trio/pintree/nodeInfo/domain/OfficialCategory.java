package com.trio.pintree.nodeInfo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "official_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OfficialCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "official_category_id")
    private Long id;
}
