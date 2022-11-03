package agh.ics.oop;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {



        out.println("Start,");
//        /* Direction */
//        Direction[] newArr = createArray(args);
//        run(newArr);
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        out.println("Stop");






    }
    private static int findLenght(String[] args){
        int counter = 0;
        for (String vals: args){
            if(vals.equals("f") || vals.equals("b") || vals.equals("l") || vals.equals("r")) {
                counter++;
            }
        }
    return counter;
    }

    public static MoveDirection[] createArray(String[] args) {
        MoveDirection[] newArr = new MoveDirection[findLenght(args)];
        int i = 0;
        for (String direction : args) {
            switch (direction) {
                case "f" -> {
                    newArr[i] = MoveDirection.FORWARD;
                    i++;
                }

                case "b" -> {
                    newArr[i] = MoveDirection.BACKWARD;
                    i++;
                }
                case "r" ->{
                    newArr[i] = MoveDirection.RIGHT;
                    i++;
                }
                case "l" ->{
                    newArr[i] = MoveDirection.LEFT;
                    i++;
                }

            }
        }
        return newArr;
    }

    public static void run(MoveDirection[] x) {
        for (MoveDirection argument : x) {
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD-> "zwierzak idzie do tyłu";
                case RIGHT -> "zwierzak skręca w prawo";
                case LEFT -> "zwierzak skręca w lewo";
            };
            out.println(message);


        }
    }


}