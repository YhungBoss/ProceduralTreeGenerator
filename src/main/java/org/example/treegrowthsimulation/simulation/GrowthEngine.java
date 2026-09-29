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

        long trunkLength = tree.getBranches().stream()
                .filter(it -> it.getOg() == tree.getTrunk())
                .count();

        System.out.println("trunk length: " + trunkLength);

        for (Branch branch : tree.getGrowingTips()) {

            if (branch.getDepth() >= 70) {
                continue;
            }

            Vector2 start = branch.getEnd();

            double baseLength = tree.getSpecies().getSegmentLength();
            double length = baseLength * Math.pow(0.95, branch.getDepth());
            double thickness = branch.getThickness() * 0.89;

            var branchOg = branch.getOg() != null
                    ? branch.getOg()
                    : branch;

            double continuationAngle;

            if (branchOg == tree.getTrunk()) {
                // Trunk stays mostly vertical
                continuationAngle = random.nextDouble(-8, 8);
            } else {
                // Smaller branches are allowed to curve more sideways
                continuationAngle = random.nextDouble(-25, 25);
            }

            Vector2 continuationDirection =
                    branch.getDirection()
                            .rotate(continuationAngle)
                            .normalize();

            if (continuationDirection.getY() > 0) {
                continuationDirection = new Vector2(
                        continuationDirection.getX(),
                        -Math.abs(continuationDirection.getY())
                ).normalize();
            }

            Branch continuation = new Branch(
                    start,
                    continuationDirection,
                    length,
                    thickness,
                    branch,
                    branch.getDepth() + 1
            );

            continuation.setOg(branchOg);

            boolean isTrunkNotMinor =
                    branchOg != tree.getTrunk() || trunkLength > 12;

            tree.getBranches().add(continuation);
            branch.addChild(continuation);
            nextGrowingTips.add(continuation);

            double branchingProbability =
                    tree.getSpecies().getBranchingProbability()
                            * Math.pow(0.998, branch.getDepth());

            if (random.nextDouble() < branchingProbability
                    && isTrunkNotMinor) {

                double sideAngle = 65 + random.nextDouble(0, 50);

                if (random.nextBoolean()) {
                    sideAngle = -sideAngle;
                }

                // Randomly choose left or right
                if (random.nextBoolean()) {
                    sideAngle = -sideAngle;
                }

                Vector2 sideDirection =
                        branch.getDirection()
                                .rotate(sideAngle)
                                .normalize();

                /*
                 * Prevent downward-growing side branches.
                 */
                if (sideDirection.getY() > 0) {
                    sideDirection = new Vector2(
                            sideDirection.getX(),
                            -Math.abs(sideDirection.getY())
                    ).normalize();
                }

                Branch sideBranch = new Branch(
                        start,
                        sideDirection,
                        length,
                        thickness,
                        branch,
                        branch.getDepth() + 1
                );

                sideBranch.setOg(sideBranch);

                branch.addChild(sideBranch);
                tree.getBranches().add(sideBranch);
                nextGrowingTips.add(sideBranch);
            }
        }

        tree.getGrowingTips().clear();
        tree.getGrowingTips().addAll(nextGrowingTips);
    }
}