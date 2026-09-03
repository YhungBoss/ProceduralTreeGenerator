package org.example.treegrowthsimulation.simulation;

import org.example.treegrowthsimulation.math.Vector2;
import org.example.treegrowthsimulation.tree.Branch;
import org.example.treegrowthsimulation.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class GrowthEngine {

    public void update(Tree tree) {

        List<Branch> nextGrowingTips = new ArrayList<>();

        for (Branch branch : tree.getGrowingTips()) {

            Vector2 start = branch.getEnd();
            Vector2 direction = branch.getDirection();
            double length = tree.getSpecies().getSegmentLength();
            double thickness = branch.getThickness();
            Branch parent = branch;

            Branch newBranch = new Branch(
                    start,
                    direction,
                    length,
                    thickness,
                    parent
            );

            parent.addChild(newBranch);
            tree.getBranches().add(newBranch);
            nextGrowingTips.add(newBranch);
        }

        tree.getGrowingTips().clear();
        tree.getGrowingTips().addAll(nextGrowingTips);
    }
}