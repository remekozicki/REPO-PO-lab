package agh.ics.oop;

import java.util.Comparator;

public class MapBoundarySetElementXPosition implements Comparator<MapBoundarySetElement> {
    @Override
    public int compare(MapBoundarySetElement p1, MapBoundarySetElement p2){
        int xResult = compareX(p1.getPosition(),p2.getPosition());
        if (xResult != 0){
            return xResult;
        }

        int yResult = compareY(p1.getPosition(),p2.getPosition());
        if (yResult != 0){
            return yResult;
        }

        if (p1.getWorldMapElement() instanceof Animal && !(p2.getWorldMapElement() instanceof Animal)){
            return 1;
        }

        return 0;

    }

    public int compareX(Vector2d p1, Vector2d p2){
        return p1.x - p2.x;
    }

    public int compareY(Vector2d p1, Vector2d p2){
        return p1.y - p2.y;
    }
}
