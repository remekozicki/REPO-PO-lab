package agh.ics.oop.gui;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class ImageLoader {
    public static HashMap<String, Image> imagesHashMap = new HashMap<>();

    public static Image getImage(String path) throws FileNotFoundException{
        if(!imagesHashMap.containsKey(path)){
            Image image = new Image(new FileInputStream(path));
            imagesHashMap.put(path, image);
        }
        return imagesHashMap.get(path);
    }
}
