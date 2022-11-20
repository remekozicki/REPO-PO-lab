package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void drawLimitsTest() {

        GrassField grassField = new GrassField(0);

        grassField.place(new Animal(grassField));
        assertEquals(new Vector2d(2, 2), grassField.lowerLeftDraw());
        assertEquals(new Vector2d(2, 2), grassField.upperRightDraw());

        grassField.place(new Animal(grassField, new Vector2d(5, 8)));
        assertEquals(new Vector2d(2, 2), grassField.lowerLeftDraw());
        assertEquals(new Vector2d(5, 8), grassField.upperRightDraw());

        grassField.place(new Animal(grassField, new Vector2d(0, 6)));
        assertEquals(new Vector2d(0, 2), grassField.lowerLeftDraw());
        assertEquals(new Vector2d(5, 8), grassField.upperRightDraw());

    }

    @Test
    public void isOccupiedTest() {

        GrassField grassField = new GrassField(0);

        Vector2d pos = new Vector2d(1, 2);
        assertFalse(grassField.isOccupied(pos));

        grassField.place(new Animal(grassField, pos));
        assertDoesNotThrow(()-> grassField.isOccupied(pos));

    }

    @Test
    public void placeTest() {

        GrassField grassField = new GrassField(6);
        Vector2d pos1 = new Vector2d(3,5);
        Vector2d pos2 = new Vector2d(3,5);
        Vector2d pos3 = new Vector2d(5,4);
        Vector2d pos4 = new Vector2d(10,-9);

        Animal animal1 = new Animal(grassField, pos1);


        assertThrows(IllegalArgumentException.class, () -> grassField.place(null));
        assertDoesNotThrow(() -> grassField.place(animal1));
        assertThrows(IllegalArgumentException.class, () -> grassField.place(new Animal(grassField, pos2)));
        assertDoesNotThrow(() -> grassField.place(new Animal(grassField, pos3)));
        assertDoesNotThrow(() -> grassField.place(new Animal(grassField, pos4)));
        assertThrows(IllegalArgumentException.class, () -> grassField.place(new Animal(grassField, null)));

    }

    @Test
    public void canMoveToTest() {

        GrassField grassField = new GrassField(12);
        Vector2d pos1 = new Vector2d(3,5);
        Animal animal1 = new Animal(grassField, pos1);

        assertDoesNotThrow(() -> grassField.canMoveTo(new Vector2d(45,2)));
        assertDoesNotThrow(() -> grassField.canMoveTo(new Vector2d(21,2)));

        grassField.place(animal1);
        assertFalse(grassField.canMoveTo(pos1));
    }

}
