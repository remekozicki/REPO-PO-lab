package agh.ics.oop;

import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap implements IWorldMap{

    private final int maxGrassY;
    private final int maxGrassX;



    public GrassField(int numberOfGrass) {
        this.maxGrassX = (int) Math.sqrt(numberOfGrass*10);
        this.maxGrassY = (int) Math.sqrt(numberOfGrass*10);

        for(int i = 0; i < numberOfGrass; i++){

            int x = ThreadLocalRandom.current().nextInt(0,this.maxGrassX+1);
            int y = ThreadLocalRandom.current().nextInt(0,this.maxGrassY+1);

            Vector2d grassPosition = new Vector2d(x,y);

            while (this.objectAt(grassPosition) != null){

                x = ThreadLocalRandom.current().nextInt(0,this.maxGrassX+1);
                y = ThreadLocalRandom.current().nextInt(0,this.maxGrassY+1);
                grassPosition = new Vector2d(x,y);
            }

            this.mapHashMap.put(grassPosition,new Grass(grassPosition));
        }
    }

    public boolean canMoveTo(Vector2d position){
        return position != null && !(this.objectAt(position)instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {

        if (!super.place(animal)) {
            return false;
        }

        this.mapHashMap.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public boolean positionChanged(Vector2d oldPosition, Vector2d newPosition){
            if (this.objectAt(newPosition) instanceof Grass) {
                this.mapHashMap.remove(newPosition);
                Vector2d grassPosition;


                do {
                    int x = ThreadLocalRandom.current().nextInt(0, this.maxGrassX + 1);
                    int y = ThreadLocalRandom.current().nextInt(0, this.maxGrassY + 1);
                    grassPosition = new Vector2d(x, y);

                } while (this.isOccupied(grassPosition));

                this.mapHashMap.put(grassPosition,new Grass(grassPosition));
            }
        return super.positionChanged(oldPosition,newPosition);
    }

    public  Vector2d lowerLeftDraw(){
        Vector2d result = mapHashMap.keySet().iterator().next();

        for (Vector2d tempPosition: mapHashMap.keySet()){
            result = result.lowerLeft(tempPosition);
        }
        return result;
    }public  Vector2d upperRightDraw(){
        Vector2d result = mapHashMap.keySet().iterator().next();

        for (Vector2d tempPosition: mapHashMap.keySet()){
            result = result.upperRight(tempPosition);
        }
        return result;
    }

}
