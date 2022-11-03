package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SimulationEngineTest {
    @Test
    public void test1() {
        IWorldMap worldMap = new RectangularMap(3, 4);
        Vector2d[] positions = {new Vector2d(1, 0), new Vector2d(2, 2), new Vector2d(0, 0)};
        String[] stringArray = {"f","right","b","l","f"};
        MoveDirection[] directions = new OptionsParser().parse(stringArray);

        IEngine simulationEngine = new SimulationEngine(directions, worldMap, positions);
        simulationEngine.run();

        MapVisualizer mapVisualizer = new MapVisualizer(worldMap);
        String result = mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(2, 3));
        System.out.println(result);
        String expectedRes =
                        " y\\x 0 1 2\n" +
                        "  4: -------\n" +
                        "  3: | | | |\n" +
                        "  2: | | |E|\n" +
                        "  1: | |W| |\n" +
                        "  0: |N| | |\n" +
                        " -1: -------\n";

        Assertions.assertEquals(expectedRes, result);
    }

    @Test
    public void test2() {
        IWorldMap worldMap = new RectangularMap(7, 5);
        Vector2d[] positions = {new Vector2d(1, 0), new Vector2d(2, 2)};
        String[] stringArray = {"f","right","b","l","f"};
        MoveDirection[] directions = new OptionsParser().parse(stringArray);

        IEngine simulationEngine = new SimulationEngine(directions, worldMap, positions);
        simulationEngine.run();

        MapVisualizer mapVisualizer = new MapVisualizer(worldMap);
        String result = mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(6, 4));
        System.out.println(result);
        String expectedRes =
                        " y\\x 0 1 2 3 4 5 6\n" +
                        "  5: ---------------\n" +
                        "  4: | | | | | | | |\n" +
                        "  3: | | | | | | | |\n" +
                        "  2: | | |N| | | | |\n" +
                        "  1: | |N| | | | | |\n" +
                        "  0: | | | | | | | |\n" +
                        " -1: ---------------\n";

        Assertions.assertEquals(expectedRes, result);
    }

    @Test
    public void test3() {
        IWorldMap worldMap = new RectangularMap(7, 5);
        Vector2d[] positions = {new Vector2d(1, 0), new Vector2d(2, 2), new Vector2d(0, 0)};
        String[] stringArray = {"f","right","l","b","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(stringArray);

        IEngine simulationEngine = new SimulationEngine(directions, worldMap, positions);
        simulationEngine.run();

        MapVisualizer mapVisualizer = new MapVisualizer(worldMap);
        String result = mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(6, 4));
        System.out.println(result);
        String expectedRes =
                        " y\\x  0 1 2 3 4 5 6\n" +
                        "  5: ---------------\n" +
                        "  4: | | | | | | | |\n" +
                        "  3: | | | | | | | |\n" +
                        "  2: | |N| | |E| | |\n" +
                        "  1: | | | | | | | |\n" +
                        "  0: |W| | | | | | |\n" +
                        " -1: ---------------\n";

        Assertions.assertEquals(expectedRes, result);
    }

    @Test
    public void test4() {
        IWorldMap worldMap = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        String[] stringArray = {"f","b","r","l","f","f","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(stringArray);

        IEngine simulationEngine = new SimulationEngine(directions, worldMap, positions);
        simulationEngine.run();


        MapVisualizer mapVisualizer = new MapVisualizer(worldMap);
        String result = mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(9, 4));
        String expectedRes =
                " y\\x  0 1 2 3 4 5 6 7 8 9\n" +
                        "  5: ---------------------\n" +
                        "  4: | | | | | | | | | | |\n" +
                        "  3: |W| | | | | | | | | |\n" +
                        "  2: | | | | | | | | | | |\n" +
                        "  1: | | | | | | | | | | |\n" +
                        "  0: | | |S| | | | | | | |\n" +
                        " -1: ---------------------\n";

        Assertions.assertEquals(expectedRes, result);

    }
}
