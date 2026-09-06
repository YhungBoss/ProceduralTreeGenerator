package org.example.treegrowthsimulation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.treegrowthsimulation.math.Vector2;
import org.example.treegrowthsimulation.rendering.TreeRenderer;
import org.example.treegrowthsimulation.simulation.GrowthEngine;
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
        GrowthEngine growthEngine = new GrowthEngine();

        renderer.render(tree, gc);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(200), event -> {

                    gc.clearRect(
                            0,
                            0,
                            canvas.getWidth(),
                            canvas.getHeight()
                    );

                    growthEngine.update(tree);

                    renderer.render(tree, gc);
                })
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

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