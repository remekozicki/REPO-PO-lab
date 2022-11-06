package agh.ics.oop;

public class Animal extends AbstractWorldMapElement{
    
    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPreviousPosition() {
        return previousPosition;
    }
    public Vector2d getPosition() {
        return this.position;
    }

    private Vector2d previousPosition;
    private MapDirection direction = MapDirection.NORTH;
    private final IWorldMap map;
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
                 Vector2d temp = switch (direction) {
                     case FORWARD -> this.position.add(this.direction.toUnitVector());
                     case BACKWARD -> this.position.subtract(this.direction.toUnitVector());
                     default -> this.position;
                 };
                 if(this.map.canMoveTo(temp)){
                    this.previousPosition = this.position;
                    this.position = temp;
                    this.map.place(this);
                 }
             }
         }
    }


}
