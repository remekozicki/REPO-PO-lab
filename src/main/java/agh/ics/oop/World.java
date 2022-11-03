package agh.ics.oop;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {


        OptionsParser parser = new OptionsParser();
        MoveDirection[] newArray = parser.parse(args);
        Animal zwierze = new Animal();
        for (MoveDirection moveDirection : newArray) {
            out.println(zwierze);
            zwierze.move(moveDirection);
        }


    }

}