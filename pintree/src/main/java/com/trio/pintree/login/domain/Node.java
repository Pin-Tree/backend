package com.trio.pintree.login.domain;

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

    private Node(boolean isMain, boolean isUp, long index, boolean isOfficial) {
        this.isMain = isMain;
        this.isUp = isUp;
        this.index = index;
        this.isOfficial = isOfficial;
    }

    public static Node createMainNode(long index, boolean isOfficial) {
        final boolean isMain = true;
        final boolean isUp = true;

        return new Node(isMain, isUp, index, isOfficial);
    }

    public static Node createNonMainNode(Node parent, boolean isUp, long index, boolean isOfficial) {
        final boolean isMain = false;

        Node node = new Node(isMain, isUp, index, isOfficial);
        ParentChild parentChild = ParentChild.create(parent, node);
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

