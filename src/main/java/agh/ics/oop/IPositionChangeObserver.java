package agh.ics.oop;

public interface IPositionChangeObserver {
    default boolean positionChanged(Object object, Vector2d oldPosition, Vector2d newPosition){
        return false;
    };
}
