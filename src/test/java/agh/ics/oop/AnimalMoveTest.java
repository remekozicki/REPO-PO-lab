//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//
//import static java.lang.System.out;
//
//public class AnimalMoveTest {
//
//    @Test
//    void test(){
//        String[] directionArray = {"f", "forward","r","backward","b","right","right","l","lalal","j","g","f"};
//
//        OptionsParser parser = new OptionsParser();
//        MoveDirection[] newArray = parser.parse(directionArray);
//        Animal zwierze = new Animal();
//        for (MoveDirection moveDirection : newArray) {
//            zwierze.move(moveDirection);
////            out.println(zwierze);
//
//        }
//        out.println("wynik: " + zwierze.isAt(new Vector2d(0,3)));
//        out.println(zwierze);
//
//    }
//}
