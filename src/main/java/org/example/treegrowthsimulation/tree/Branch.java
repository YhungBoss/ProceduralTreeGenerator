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

    private final List<Branch> children;

    public Branch(Vector2 start, Vector2 direction, double length, double thickness, Branch parent) {
        this.start = start;
        this.direction = direction;
        this.length = length;
        this.thickness = thickness;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public Vector2 getStart() {

        return start;
    }

    public Vector2 getDirection() {

        return direction;
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

    public void addChild(Branch child) {

        children.add(child);
    }

    public Vector2 getEnd() {

        return start.add(direction.multiply(length));
    }
}