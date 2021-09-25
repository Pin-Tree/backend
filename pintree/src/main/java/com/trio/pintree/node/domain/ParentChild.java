package com.trio.pintree.node.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Table(name = "parent_child")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParentChild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_child_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private Node parent;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Node child;

    private ParentChild(Node parent, Node child) {
        this.parent = parent;
        this.child = child;
    }

    public static ParentChild of(Node parent, Node child) {
        return new ParentChild(parent, child);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentChild that = (ParentChild) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
