package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;


public class RectangularMap extends AbstractWorldMap implements IWorldMap{

    private int width;
    private int height;

    private Vector2d upperRight;
    private final Vector2d lowerLeft = new Vector2d(0, 0);

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

        if(isOccupied(animal.getPosition())) return false;
        if(!canMoveTo(animal.getPosition())) return false;

        if(animal.getPreviousPosition() != null){
            this.mapHashMap.remove(animal.getPreviousPosition());
        }
//        System.out.println(mapHashMap);
        this.mapHashMap.put(animal.getPosition(),animal);
        System.out.println(mapHashMap);


        return true;
    }
    @Override
    public Object objectAt(Vector2d position) {
        return this.mapHashMap.get(position);
    }

    public Vector2d lowerLeftDraw() {
        return new Vector2d(0, 0);
    }

    public Vector2d upperRightDraw() {
        return new Vector2d(this.width - 1, this.height - 1);
    }
}
