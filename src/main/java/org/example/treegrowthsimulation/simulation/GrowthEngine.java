package org.example.treegrowthsimulation.simulation;

import org.example.treegrowthsimulation.math.Vector2;
import org.example.treegrowthsimulation.tree.Branch;
import org.example.treegrowthsimulation.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrowthEngine {

    private final Random random = new Random();

    public void update(Tree tree) {

        List<Branch> nextGrowingTips = new ArrayList<>();

        for (Branch branch : tree.getGrowingTips()) {

            if (branch.getDepth() >= 12) {
                continue;
            }

            Vector2 start = branch.getEnd();

            double baseLength = tree.getSpecies().getSegmentLength();
            double length = baseLength * Math.pow(0.95, branch.getDepth());
            double thickness = branch.getThickness() * 0.89;

            // Slightly change the continuation direction
            double continuationAngle = random.nextDouble(-8, 9);
            Vector2 continuationDirection =
                    branch.getDirection().rotate(continuationAngle);

            Branch continuation = new Branch(
                    start,
                    continuationDirection,
                    length,
                    thickness,
                    branch,
                    branch.getDepth() + 1
            );

            branch.addChild(continuation);
            tree.getBranches().add(continuation);
            nextGrowingTips.add(continuation);

            // Sometimes create a side branch
            double branchingProbability =
                    tree.getSpecies().getBranchingProbability()
                            * Math.pow(0.85, branch.getDepth());
            if (random.nextDouble() < branchingProbability) {

                double sideAngle = random.nextDouble(-50, 51);
                Vector2 sideDirection =
                        branch.getDirection().rotate(sideAngle);

                Branch sideBranch = new Branch(
                        start,
                        sideDirection,
                        length,
                        thickness,
                        branch,
                        branch.getDepth() + 1
                );

                branch.addChild(sideBranch);
                tree.getBranches().add(sideBranch);
                nextGrowingTips.add(sideBranch);
            }
        }

        tree.getGrowingTips().clear();
        tree.getGrowingTips().addAll(nextGrowingTips);
    }
}