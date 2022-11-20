package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {

        Application.launch(App.class, args);

        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,1), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            out.println(map);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new RectangularMap(5,5);
            Vector2d[] positions = { new Vector2d(2,1), new Vector2d(4,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            out.println(map);
        }
        catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }

    }

}