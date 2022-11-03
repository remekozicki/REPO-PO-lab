package agh.ics.oop;

public class GrassField implements IWorldMap{

    private final int maxGrassY;
    private final int maxGrassX;



    public GrassField(int numberOfGrass) {
        this.maxGrassX = (int) Math.sqrt(numberOfGrass*10);
        this.maxGrassY = (int) Math.sqrt(numberOfGrass*10);

        for(int i = 0; i < numberOfGrass; i++){

        }
    }
}
