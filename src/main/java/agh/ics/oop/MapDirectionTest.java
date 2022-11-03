package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapDirectionTest {
    @Test
    void test(){

        MapDirection direction1 = MapDirection.NORTH;
        MapDirection direction2 = MapDirection.SOUTH;
        MapDirection direction3 = MapDirection.WEST;
        MapDirection direction4 = MapDirection.EAST;
        System.out.println(direction1.next().toString());
        System.out.println(direction2.next().toString());
        System.out.println(direction3.next().toString());
        System.out.println(direction4.next().toString());
        System.out.println(direction1.previos().toString());
        System.out.println(direction2.previos().toString());
        System.out.println(direction3.previos().toString());
        System.out.println(direction4.previos().toString());
    }


}
