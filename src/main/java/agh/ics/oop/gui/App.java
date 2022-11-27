package agh.ics.oop.gui;

import agh.ics.oop.*;
import agh.ics.oop.AbstractWorldMapElement;
import agh.ics.oop.AbstractWorldMap;
import agh.ics.oop.GrassField;
import agh.ics.oop.IWorldMap;
import agh.ics.oop.OptionsParser;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class App extends Application implements IMapRefreshObserver{
    private NewSimulationEngine engine;
    private Thread engineThread;
    private GridPane mapGrid;
    private AbstractWorldMap map;
    @Override
    public void init() throws Exception {
        super.init();

        try{
            this.map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,1), new Vector2d(3,4) };

            this.engine = new NewSimulationEngine(300, map, positions);
            this.engine.addObserver(this);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }

    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });

        this.mapGrid = new GridPane();
        mapGrid.setHgap(0);
        mapGrid.setVgap(0);

        VBox root = new VBox();
        TextField textField = new TextField();
        Button button = new Button("Start");
        button.setOnAction(event -> {
            String[] strMoves = textField.getCharacters().toString().split(" ");
            MoveDirection[] moves = new OptionsParser().parse(strMoves);
            this.engine.setMoveArray(moves);
            this.engineThread = new Thread(this.engine);
            this.engineThread.start();
        });

        root.getChildren().addAll(textField, button);
        root.getChildren().add(mapGrid);
        renderGrid(mapGrid);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    void renderGridAndNextRender(GridPane gridPane, int cellWidth, int cellHeight) throws FileNotFoundException {
        gridPane.getChildren().clear();
        out.println(gridPane.getChildren());
        renderGrid(gridPane);
    }

    void renderGrid(GridPane gridPane) throws FileNotFoundException {


        int minY = this.map.lowerLeftDraw().y;
        int minX = this.map.lowerLeftDraw().x;
        int maxY = this.map.upperRightDraw().y;
        int maxX = this.map.upperRightDraw().x;

        Label xyLabel = new Label("y\\x");
        GridPane.setHalignment(xyLabel, HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(GUIConfig.mapGridCellWidth));
        gridPane.getRowConstraints().add(new RowConstraints(GUIConfig.getMapGridCellHeight));
        gridPane.add(xyLabel, 0, 0, 1, 1);


        for (int i = minY; i <= maxY; i++) {
            Label label = new Label(Integer.toString(i));
            gridPane.add(label, 0, maxY - i + 1, 1, 1);
            gridPane.getRowConstraints().add(new RowConstraints(GUIConfig.getMapGridCellHeight));
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for (int i = minX; i <= maxX; i++) {
            Label label = new Label(Integer.toString(i));
            gridPane.add(label, i-minX+1, 0, 1, 1);
            gridPane.getColumnConstraints().add(new ColumnConstraints(GUIConfig.mapGridCellWidth));
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                Vector2d position = new Vector2d(x, y);
                if (!this.map.isOccupied(position)) {
                    continue;
                }

                IMapElement worldMapElement = (IMapElement) this.map.objectAt(position);
                GuiElementBox element = new GuiElementBox(worldMapElement);
                VBox graphicElement = element.getGraphicElement();
                GridPane.setHalignment(graphicElement, HPos.CENTER);
                gridPane.add(graphicElement, position.x - minX + 1, maxY - position.y +1, 1, 1);

            }
        }

    }
    @Override
    public void refresh(){
        Platform.runLater(() ->{
            this.mapGrid.getChildren().clear();
            try {
                this.renderGrid(this.mapGrid);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}