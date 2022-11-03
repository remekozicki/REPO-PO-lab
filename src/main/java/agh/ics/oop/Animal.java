package agh.ics.oop;

public class Animal{
    
    public MapDirection getMapPosition() {
        return mapPosition;
    }

    public Vector2d getPeviousVectorCoordinates() {
        return peviousVectorCoordinates;
    }

    public Vector2d getVectorCoordinates() {
        return vectorCoordinates;
    }


    public IWorldMap getMap() {
        return map;
    }

    private Vector2d peviousVectorCoordinates;
    private MapDirection mapPosition = MapDirection.NORTH;
    private Vector2d vectorCoordinates = new Vector2d(2, 2);

    private final IWorldMap map;

    Animal(IWorldMap map){
        this.map = map;
    }
    Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.vectorCoordinates = initialPosition;
    }

    @Override
    public String toString(){

        String toPrint = switch (this.mapPosition){
            case NORTH -> "N";
            case EAST -> "E";
            case WEST -> "W";
            case SOUTH -> "S";
        };

        return toPrint;

    }
    boolean isAt(Vector2d position){
        return position.equals(vectorCoordinates);
    }

     void move(MoveDirection direction){
         switch (direction) {
             case RIGHT -> this.mapPosition = this.mapPosition.next();
             case LEFT -> this.mapPosition = this.mapPosition.previos();
             default -> {
                 Vector2d temp = switch (direction) {
                     case FORWARD -> this.vectorCoordinates.add(mapPosition.toUnitVector());
                     case BACKWARD -> this.vectorCoordinates.subtract(mapPosition.toUnitVector());
                     default -> this.vectorCoordinates;
                 };
                 if(this.map.canMoveTo(temp)){
                    this.peviousVectorCoordinates = this.vectorCoordinates;
                    this.vectorCoordinates = temp;
                    this.map.place(this);
                 }
             }
         }
    }


}
