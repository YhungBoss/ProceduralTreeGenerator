package org.example.treegrowthsimulation.tree;

public enum TreeSpecies {

    OAK(
            20,
            10,
            0.65,
            0.35
    );

    private final double segmentLength;
    private final double initialThickness;
    private final double lightAttraction;
    private final double branchingProbability;

    TreeSpecies(
            double segmentLength,
            double initialThickness,
            double lightAttraction,
            double branchingProbability
    ) {
        this.segmentLength = segmentLength;
        this.initialThickness = initialThickness;
        this.lightAttraction = lightAttraction;
        this.branchingProbability = branchingProbability;
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

    public double getBranchingProbability() {return branchingProbability;}
}