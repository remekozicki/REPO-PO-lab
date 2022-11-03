package agh.ics.oop;

public class Animal {

    private MapDirection mapPosition;
    private Vector2d vector;

    public Animal (){
        this.mapPosition = MapDirection.NORTH;
        this.vector = new Vector2d(2,2);
    }

    @Override
    public String toString() {
        return "position " + mapPosition.toString() + " direction " + vector.toString();

    }
    boolean isAt(Vector2d position){
        return position.equals(vector);
    }

     void move(MoveDirection direction){
         switch (direction) {
             case RIGHT -> this.mapPosition = this.mapPosition.next();
             case LEFT -> this.mapPosition = this.mapPosition.previos();
             case FORWARD -> {
                 Vector2d temp1 = this.vector.add(mapPosition.toUnitVector());
                 if (temp1.x >= 0 && temp1.x <= 4 && temp1.y >= 0 && temp1.y <= 4) {
                     this.vector = this.vector.add(mapPosition.toUnitVector());
                 }
             }
             case BACKWARD -> {
                 Vector2d temp2 = this.vector.subtract(mapPosition.toUnitVector());
                 if (temp2.x >= 0 && temp2.x <= 4 && temp2.y >= 0 && temp2.y <= 4) {
                     this.vector = this.vector.subtract(mapPosition.toUnitVector());
                 }

             }
         }
    }

}
