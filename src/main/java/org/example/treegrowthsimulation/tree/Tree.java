package org.example.treegrowthsimulation.tree;

import org.example.treegrowthsimulation.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private final Branch trunk;

    private final List<Branch> branches;

    private final List<Branch> growingTips;

    private final TreeSpecies species;

    public Tree(TreeSpecies species, Vector2 rootPosition) {

        this.species = species;

        this.branches = new ArrayList<>();
        this.growingTips = new ArrayList<>();

        this.trunk = new Branch(
                rootPosition,
                new Vector2(0, -1),
                species.getSegmentLength(),
                species.getInitialThickness(),
                null,
                0,
                0
        );

        this.branches.add(trunk);
        this.growingTips.add(trunk);
    }

    public Branch getTrunk() {
        return trunk;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public List<Branch> getGrowingTips() {
        return growingTips;
    }

    public TreeSpecies getSpecies() {
        return species;
    }
}