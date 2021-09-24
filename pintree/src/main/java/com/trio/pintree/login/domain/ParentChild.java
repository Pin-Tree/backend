package com.trio.pintree.login.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParentChild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_child_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Node parent;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Node child;

}
