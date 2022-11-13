package agh.ics.oop;

import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected final HashMap<Vector2d,AbstractWorldMapElement> mapHashMap = new HashMap<>();


    @Override
    public boolean isOccupied(Vector2d position) {
        return this.mapHashMap.containsKey(position);
    }
    @Override
    public Object objectAt(Vector2d position){
        return this.mapHashMap.get(position);
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.lowerLeftDraw(), this.upperRightDraw());
    }

    @Override
    public boolean place(Animal animal){

        if(this.mapHashMap.get(animal.getPosition()) instanceof Animal) return false;

        animal.addObserver(this);

        return true;
    }

    public boolean positionChanged(Vector2d oldPosition, Vector2d newPosition){
        AbstractWorldMapElement worldMapElement = this.mapHashMap.get(oldPosition);
        this.mapHashMap.put(newPosition, worldMapElement);
        this.mapHashMap.remove(oldPosition);

        return true;
    }

    public abstract Vector2d lowerLeftDraw();
    public abstract Vector2d upperRightDraw();
}
