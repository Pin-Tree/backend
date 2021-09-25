package com.trio.pintree.node.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Table(name = "node")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "node_id")
    private Long id;

    @Column(name = "node_name")
    private String name;

    @Column(name = "is_main")
    private boolean isMain = false;

    @Column(name = "is_up")
    private boolean isUp = true;

    @Column(name = "is_official")
    private boolean isOfficial = false;

    @Column(name = "node_index")
    private long index;

    @Column(name = "node_memo")
    private String memo;

    @OneToOne(mappedBy = "child")
    private ParentChild parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<ParentChild> children = new ArrayList<>();

    private Node(String name, long index, boolean isMain, boolean isOfficial, boolean isUp) {
        this.name = name;
        this.index = index;
        this.isMain = isMain;
        this.isOfficial = isOfficial;
        this.isUp = isUp;
    }

    public static Node createMainNode(String name, long index, boolean isOfficial) {
        final boolean isMain = true;
        final boolean isUp = true;

        return new Node(name, index, isMain, isOfficial, isUp);
    }

    public static Node createNonMainNode(String name, long index, boolean isOfficial, boolean isUp, Node parent) {
        final boolean isMain = false;
        Node node = new Node(name, index, isOfficial, isMain, isUp);

        ParentChild parentChild = ParentChild.of(parent, node);
        parent.addChild(parentChild);
        node.addParent(parentChild);
        return node;
    }

    private void addChild(ParentChild parentChild) {
        children.add(parentChild);
    }

    private void addParent(ParentChild parentChild) {
        this.parent = parentChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id.equals(node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

