package agh.ics.oop;
import java.util.ArrayList;

public class NewSimulationEngine implements IEngine, Runnable{
    private IWorldMap map;
    private MoveDirection[] moveArray;
    private ArrayList<Animal> animalsList = new ArrayList<>();
    private ArrayList<IMapRefreshObserver> mapRefreshObservers = new ArrayList<>();

    private final int moveDelay;

    public NewSimulationEngine(int moveDelay, IWorldMap map, Vector2d[] initialPositions) {
        this.moveDelay = moveDelay;
        this.map = map;

        for(Vector2d newPosition: initialPositions)
            animalsList.add(new Animal(this.map, newPosition));

        for(Animal animal: animalsList){
            this.map.place(animal);

        }
    }

    public NewSimulationEngine(MoveDirection[] moveArray, IWorldMap map, Vector2d[] initialPositions, int moveDelay){
        this(moveDelay, map, initialPositions);
        this.setMoveArray(moveArray);
    }

    void mapRefresh(){
        for(IMapRefreshObserver observer: this.mapRefreshObservers){
            observer.refresh();
        }
    }



    @Override
    public void run() {
        try {
            for (int i = 0; i < moveArray.length; i++) {
                this.animalsList.get(i % animalsList.size()).move(moveArray[i]);

                this.mapRefresh();
                Thread.sleep(moveDelay);
            }
        }
        catch (InterruptedException e){
            System.err.println("Interuption while waiting for animal to move!");
        }
    }

    public void setMoveArray(MoveDirection[] moveArray){
        this.moveArray = moveArray;
    }

    public void addObserver(IMapRefreshObserver observer){
        this.mapRefreshObservers.add(observer);
    }

    public void removeObserver(IMapRefreshObserver observer){
        this.mapRefreshObservers.remove(observer);
    }

}
