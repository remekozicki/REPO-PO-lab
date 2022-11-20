package agh.ics.oop;

import java.util.ArrayList;

abstract public class AbstractMoveWorldMapElement extends AbstractWorldMapElement{
    private final ArrayList<IPositionChangeObserver> observersPosition = new ArrayList<>();

    public AbstractMoveWorldMapElement(Vector2d position){
        super(position);
    }
    public void addObserver(IPositionChangeObserver observer){
        this.observersPosition.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.observersPosition.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer: this.observersPosition){
            observer.positionChanged(this, oldPosition,newPosition);
        }
    }


}
