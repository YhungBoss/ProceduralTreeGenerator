package org.example.treegrowthsimulation.tree;

public enum TreeSpecies {

    OAK(
            200,
            10,
            0.65
    );

    private final double segmentLength;
    private final double initialThickness;
    private final double lightAttraction;

    TreeSpecies(double segmentLength, double initialThickness, double lightAttraction) {
        this.segmentLength = segmentLength;
        this.initialThickness = initialThickness;
        this.lightAttraction = lightAttraction;
    }

    public double getSegmentLength() {
        return segmentLength;
    }

    public double getInitialThickness() {
        return initialThickness;
    }

    public double getLightAttraction() {
        return lightAttraction;
    }
}