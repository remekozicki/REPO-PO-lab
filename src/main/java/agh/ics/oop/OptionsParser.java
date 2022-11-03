package agh.ics.oop;

public class OptionsParser {

    String[] checkArray = {"f", "forward","b","backward","r","right","l","left"};
    private static int findLenght(String[] args, String[] checkArray){
        int counter = 0;
        for (String vals: args){
            for(String check: checkArray){
                if(vals.equals(check)){
                    counter++;
            }

            }
        }
        return counter;
    }

    MoveDirection[] parse(String[] args) {
        MoveDirection[] newArr = new MoveDirection[findLenght(args, checkArray)];
        int i = 0;
        for (String direction : args) {
            switch (direction) {
                case "f", "forward" -> {
                    newArr[i] = MoveDirection.FORWARD;
                    i++;
                }

                case "b", "backward" -> {
                    newArr[i] = MoveDirection.BACKWARD;
                    i++;
                }
                case "r", "right" ->{
                    newArr[i] = MoveDirection.RIGHT;
                    i++;
                }
                case "l", "left" ->{
                    newArr[i] = MoveDirection.LEFT;
                    i++;
                }

            }
        }
        return newArr;
    }

}
