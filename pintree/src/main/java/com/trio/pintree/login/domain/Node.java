package com.trio.pintree.login.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Node {

    @Id @GeneratedValue
    @Column(name = "node_id")
    private Long id;

    @Column(name = "is_main")
    private boolean isMain;

    @Column(name = "is_up")
    private boolean isUp;

    @Column(name = "node_index")
    private int index;

    @Column(name = "node_memo")
    private String memo;

    @Column(name = "is_official")
    private boolean isOfficial;

    @OneToOne(mappedBy = "parent")
    private ParentChild parent;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL)
    private List<ParentChild> children = new ArrayList<>();


    @OneToMany(mappedBy = "child")
    private List<Children> children = new ArrayList<>();

}

