package agh.ics.oop;

import java.util.ArrayList;

public class Animal extends AbstractWorldMapElement{
    
    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return this.position;
    }


    private MapDirection direction = MapDirection.NORTH;
    private final IWorldMap map;

    private final ArrayList<IPositionChangeObserver> observersPosition = new ArrayList<>();
//never used
    public Animal(IWorldMap map){
        super(new Vector2d(2,2));
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition) {
        super(initialPosition);
        this.map = map;
    }

    @Override
    public String toString(){

        String toPrint = switch (this.direction){
            case NORTH -> "N";
            case EAST -> "E";
            case WEST -> "W";
            case SOUTH -> "S";
        };

        return toPrint;

    }
    boolean isAt(Vector2d position){
        return position.equals(position);
    }

     void move(MoveDirection direction){
         switch (direction) {
             case RIGHT -> this.direction = this.direction.next();
             case LEFT -> this.direction = this.direction.previos();
             default -> {
                 Vector2d tempPosition = switch (direction) {
                     case FORWARD -> this.position.add(this.direction.toUnitVector());
                     case BACKWARD -> this.position.subtract(this.direction.toUnitVector());
                     default -> this.position;
                 };
                 if(this.map.canMoveTo(tempPosition)){
                    this.positionChanged(this.position,tempPosition);
                    this.position = tempPosition;
                 }
             }
         }
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observersPosition.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.observersPosition.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer: this.observersPosition){
            observer.positionChanged(oldPosition,newPosition);
        }
    }



}
