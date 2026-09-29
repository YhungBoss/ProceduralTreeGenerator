package org.example.treegrowthsimulation.tree;

import org.example.treegrowthsimulation.math.Vector2;

public class Leaf {

    private final Vector2 position;
    private final double size;
    private final double angle;

    public Leaf(Vector2 position, double size, double angle) {
        this.position = position;
        this.size = size;
        this.angle = angle;
    }

    public Vector2 getPosition() {
        return position;
    }

    public double getSize() {
        return size;
    }

    public double getAngle() {
        return angle;
    }
}