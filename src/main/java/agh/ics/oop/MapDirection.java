package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        return switch (this) {
            case NORTH -> "Polnoc";
            case SOUTH -> "Poludnie";
            case WEST -> "Zachod";
            case EAST -> "Wschod";
        };
    }
    MapDirection next(){
        return switch (this){
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case NORTH -> EAST;
        };
    }
    MapDirection previos(){
        return switch (this){
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case NORTH -> WEST;
            case EAST -> NORTH;
        };
    }
    Vector2d toUnitVector(){
        return switch (this){
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
            case NORTH -> new Vector2d(0,1);
            case EAST -> new Vector2d(1,0);
        };
    }

    public String toCordsString(){
        return this.name().substring(0,1);
    }
}
