package org.example.treegrowthsimulation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import org.example.treegrowthsimulation.math.Vector2;
import org.example.treegrowthsimulation.rendering.TreeRenderer;
import org.example.treegrowthsimulation.tree.Tree;
import org.example.treegrowthsimulation.tree.TreeSpecies;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        Canvas canvas = new Canvas(800, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Tree tree = new Tree(
                TreeSpecies.OAK,
                new Vector2(400, 700)
        );

        TreeRenderer renderer = new TreeRenderer();
        renderer.render(tree, gc);

        Group root = new Group(canvas);

        Scene scene = new Scene(root, 800, 800);

        stage.setTitle("Tree Growth Simulation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}