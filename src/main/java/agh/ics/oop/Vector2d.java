package agh.ics.oop;

public class Vector2d {
    public final int x,y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return x + " " + y;
    }

    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }
    public boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }
    public Vector2d upperRight(Vector2d other){
        int x,y;
        x = Math.max(this.x, other.x);
        y = Math.max(this.y, other.y);
        return new Vector2d(x,y);
    }
    public Vector2d lowerLeft(Vector2d other){
        int x,y;
        x = Math.min(this.x, other.x);
        y = Math.min(this.y, other.y);
        return new Vector2d(x,y);
    }
    public Vector2d add(Vector2d other){
        int x,y;
        x = this.x + other.x;
        y = this.y + other.y;
        return new Vector2d(x,y);
    }
    public Vector2d subtract(Vector2d other){
        int x,y;
        x = this.x - other.x;
        y = this.y - other.y;
        return new Vector2d(x,y);
    }
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d that))
            return false;
        return x == that.x && y == that.y;
    }
    public Vector2d opposite(){
        return new Vector2d(-this.x,-this.y);
    }

}
