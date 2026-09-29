package org.example.treegrowthsimulation.rendering;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.example.treegrowthsimulation.math.Vector2;
import org.example.treegrowthsimulation.tree.Branch;
import org.example.treegrowthsimulation.tree.Tree;
import org.example.treegrowthsimulation.tree.Leaf;
import javafx.scene.paint.Color;

public class TreeRenderer {

    public void render(Tree tree, GraphicsContext gc) {

        gc.setStroke(Color.SADDLEBROWN);

        for (Branch branch : tree.getBranches()) {

            Vector2 start = branch.getStart();
            Vector2 end = branch.getEnd();

            gc.setLineWidth(branch.getThickness());

            gc.strokeLine(
                    start.getX(),
                    start.getY(),
                    end.getX(),
                    end.getY()
            );
        }

        for (Branch branch : tree.getBranches()) {

            Leaf leaf = branch.getLeaf();

            if (leaf != null) {
                double x = leaf.getPosition().getX();
                double y = leaf.getPosition().getY();
                double size = leaf.getSize();

                gc.save();

                gc.translate(x, y);
                gc.rotate(leaf.getAngle());

                gc.setFill(Color.FORESTGREEN);
                gc.fillOval(
                        -size / 2,
                        -size / 4,
                        size,
                        size / 2
                );

                gc.restore();
            }
        }
    }
}