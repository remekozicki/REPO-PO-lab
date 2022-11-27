package agh.ics.oop;

public class Grass extends AbstractWorldMapElement{
    String imageBasePath = "src/main/resources/";

    public Grass(Vector2d position) {
        super(position);
    }
    @Override
    public String toString(){
        return "*";
    }

    @Override
    public String getImageResource() {
        return imageBasePath + "grass.png";

    }

    @Override
    public String toStringRepresentation() {
        return "T " + this.position.toString();

    }

}
