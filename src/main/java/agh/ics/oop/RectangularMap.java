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
//        return ((position.precedes(this.upperRight) && position.follows(this.lowerLeft)) && !isOccupied(position));
        if ((position.precedes(this.upperRight) && position.follows(this.lowerLeft)) && !isOccupied(position)){
            return true;
        }else{
            throw new IllegalArgumentException("poza mapa");
        }
    }

    public boolean isInside(Vector2d position){
        return position != null && position.precedes(this.upperRight) && position.follows(this.lowerLeft);
    }

    @Override
    public void place(Animal animal) {

        super.place(animal);

        if(!canMoveTo(animal.getPosition())){
            animal.removeObserver(this);
            throw new IllegalArgumentException("Object can't be placed on position " + animal.getPosition() + ". It is outside the world borders.");
        }
        this.mapHashMap.put(animal.getPosition(),animal);
//        System.out.println(mapHashMap);
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
