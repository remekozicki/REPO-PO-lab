package agh.ics.oop;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        Direction[] newArr = new Direction[args.length];



        out.println("Start,");

        createArray(args, newArr);
        run(newArr);
        out.println("Stop");



    }

    public static void createArray(String[] args, Direction[] newArr) {
        for (int i = 0; i < newArr.length; i++) {
            switch (args[i]) {
                case "f" -> newArr[i] = Direction.FORWARD;
                case "b" -> newArr[i] = Direction.BACKWARD;
                case "r" -> newArr[i] = Direction.RIGHT;
                case "l" -> newArr[i] = Direction.LEFT;
                default -> newArr[i] = Direction.UNDEFINED;
            }
        }
    }

    public static void run(Direction[] x) {
        for (Direction argument : x) {
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD-> "zwierzak idzie do tyłu";
                case RIGHT -> "zwierzak skręca w prawo";
                case LEFT -> "zwierzak skręca w lewo";

                default -> "";
            };
            if (message.length() > 0) {
                out.println(message);
            }

        }
    }


}