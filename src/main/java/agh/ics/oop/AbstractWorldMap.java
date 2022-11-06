package agh.ics.oop;

import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap{
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

    public abstract Vector2d lowerLeftDraw();
    public abstract Vector2d upperRightDraw();
}
