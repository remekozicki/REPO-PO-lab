package agh.ics.oop.gui;

import agh.ics.oop.*;
import agh.ics.oop.AbstractWorldMapElement;
import agh.ics.oop.AbstractWorldMap;
import agh.ics.oop.GrassField;
import agh.ics.oop.IWorldMap;
import agh.ics.oop.OptionsParser;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class App extends Application {
    private AbstractWorldMap map;
    @Override
    public void init() throws Exception {
        super.init();

        Parameters parameters = getParameters();
        List<String> argsList = parameters.getRaw();

        String[] args = new String[argsList.size()];
        args = argsList.toArray(args);

        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            this.map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,1), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            out.println(map);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }

//        try{
//            MoveDirection[] directions = new OptionsParser().parse(args);
//            this.map = new RectangularMap(5,5);
//            this.map = new RectangularMap(5,5);
//            Vector2d[] positions = { new Vector2d(2,1), new Vector2d(4,4) };
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//            out.println(map);
//        }
//        catch (IllegalArgumentException exception){
//            exception.printStackTrace();
//        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        int cellWidth = 30;
        int cellHeight = 30;

        int minY = this.map.lowerLeftDraw().y;
        int minX = this.map.lowerLeftDraw().x;
        int maxY = this.map.upperRightDraw().y;
        int maxX = this.map.upperRightDraw().x;

        Label xyLabel = new Label("y\\x");
        GridPane.setHalignment(xyLabel, HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(cellWidth));
        gridPane.getRowConstraints().add(new RowConstraints(cellHeight));
        gridPane.add(xyLabel, 0, 0, 1, 1);


        for (int i = minY; i <= maxY; i++) {
            Label label = new Label(Integer.toString(i));
            gridPane.add(label, 0, maxY - i + 1, 1, 1);
            gridPane.getRowConstraints().add(new RowConstraints(cellHeight));
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for (int i = minX; i <= maxX; i++) {
            Label label = new Label(Integer.toString(i));
            gridPane.add(label, i-minX+1, 0, 1, 1);
            gridPane.getColumnConstraints().add(new ColumnConstraints(cellWidth));
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                Vector2d position = new Vector2d(x, y);
                if (!this.map.isOccupied(position)) {
                    continue;
                }

                Object worldMapElement = this.map.objectAt(position);
                Label label = new Label(worldMapElement.toString());
                GridPane.setHalignment(label, HPos.CENTER);
                gridPane.add(label, position.x - minX + 1, maxY - (position.y - minY), 1, 1);
            }
        }


        Scene scene = new Scene(gridPane, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}