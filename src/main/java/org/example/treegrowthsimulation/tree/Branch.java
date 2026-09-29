package org.example.treegrowthsimulation.tree;

import org.example.treegrowthsimulation.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private final Vector2 start;
    private final Vector2 direction;

    private final double length;
    private final double thickness;

    private final Branch parent;
    private Branch ogParent;

    private final List<Branch> children;
    private final int depth;
    private final int actualDepth;

    private Leaf leaf;

    public Branch(
            Vector2 start,
            Vector2 direction,
            double length,
            double thickness,
            Branch parent,
            int depth,
            int actualDepth
    ) {
        this.start = start;
        this.direction = direction;
        this.length = length;
        this.thickness = thickness;
        this.parent = parent;
        this.children = new ArrayList<>();
        this.depth = depth;
        this.actualDepth = actualDepth;
    }

    public Vector2 getStart() {

        return start;
    }

    public Vector2 getDirection() {

        return direction;
    }

    public int getActualDepth() {

        return actualDepth;
    }

    public double getLength() {

        return length;
    }

    public double getThickness() {

        return thickness;
    }

    public Branch getParent() {

        return parent;
    }

    public List<Branch> getChildren() {

        return children;
    }

    public Branch getOg() {

        return ogParent;
    }

    public void setOg(Branch og) {

        ogParent = og;
    }

    public void addChild(Branch child) {

        children.add(child);
    }

    public Vector2 getEnd() {

        return start.add(direction.multiply(length));
    }
    public Leaf getLeaf() {
        return leaf;
    }

    public void setLeaf(Leaf leaf) {
        this.leaf = leaf;
    }

    public int getDepth() {
        return depth;
    }
}

