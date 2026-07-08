package org.example.treegrowthsimulation.rendering;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.example.treegrowthsimulation.math.Vector2;
import org.example.treegrowthsimulation.tree.Branch;
import org.example.treegrowthsimulation.tree.Tree;

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
    }
}