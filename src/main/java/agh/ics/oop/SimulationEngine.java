package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

    private IWorldMap map;
    private MoveDirection[] moveArray;
    private ArrayList<Animal> animalsList = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moveArray, IWorldMap map, Vector2d[] initialPositions) {

        this.moveArray = moveArray;
        this.map = map;

        for(Vector2d newPosition: initialPositions)
            animalsList.add(new Animal(this.map, newPosition));

        for(Animal animal: animalsList){
            if(this.map.canMoveTo(animal.getVectorCoordinates())){
                this.map.place(animal);
            }

        }
    }

    @Override
    public void run() {
        for(int i = 0; i < moveArray.length; i++){
            this.animalsList.get( i % animalsList.size()).move(moveArray[i]);
            System.out.println("animal"+i % animalsList.size() +":" + this.animalsList.get( i % animalsList.size()).getVectorCoordinates()+
                    this.animalsList.get( i % animalsList.size()).getMapPosition());
        }
    }
}