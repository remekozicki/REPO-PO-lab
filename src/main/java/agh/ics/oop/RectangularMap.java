package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;


public class RectangularMap implements IWorldMap{

    private int width;
    private int height;

    private Vector2d upperRight;
    private final Vector2d lowerLeft = new Vector2d(0, 0);

    private Map<Vector2d,Animal> mapHashMap = new HashMap<>();

    public RectangularMap(){
        this.width = 5;
        this.height = 5;
        this.upperRight = new Vector2d(width -1, height -1);
    }

    public RectangularMap(int width, int height) {
        this();
        if (width > 0 || height > 0) {
            this.width = width;
            this.height = height;
            this.upperRight = new Vector2d(width - 1, height - 1);
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return ((position.precedes(this.upperRight) && position.follows(this.lowerLeft)) && !isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) {
        if(animal == null) return false;
        if(animal.getVectorCoordinates() == null) return false;
        if(isOccupied(animal.getVectorCoordinates())) return false;
        if(!canMoveTo(animal.getVectorCoordinates())) return false;

        if(animal.getPeviousVectorCoordinates() != null){
            this.mapHashMap.remove(animal.getPeviousVectorCoordinates());
        }
        this.mapHashMap.put(animal.getVectorCoordinates(),animal);

        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return mapHashMap.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.mapHashMap.get(position);
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.lowerLeft, this.upperRight);
    }
}
