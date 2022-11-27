package agh.ics.oop.gui;

import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import java.util.Arrays;

public class ColorGenerator {
    public static Image generateColor(int width, int height, double red, double green, double blue){
        WritableImage img = new WritableImage(width, height);
        PixelWriter pw = img.getPixelWriter();

        int r = (int) (red * 255);
        int g = (int) (green * 255);
        int b = (int) (blue * 255);

        int pixel = (r << 16) | (g << 8) | b;
        int[] pixels = new int[width * height];
        Arrays.fill(pixels,pixel);

        pw.setPixels(0, 0, width, height, PixelFormat.getIntArgbInstance(), pixels, 0, width);
        return img;
    }
}
