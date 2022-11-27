package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.Grass;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static agh.ics.oop.gui.ColorGenerator.generateColor;


public class GuiElementBox {

    protected Label label;
    protected IMapElement mapElement;
    protected VBox graphicElement = new VBox();

    public GuiElementBox(IMapElement mapElement) throws FileNotFoundException {
        this.mapElement = mapElement;
        Image image;

        image = new Image(new FileInputStream(mapElement.getImageResource()));


        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);

        this.label = new Label(this.mapElement.toStringRepresentation());
        this.label.setFont(Font.font(10d));

        this.graphicElement.getChildren().add(imageView);
        this.graphicElement.getChildren().add(label);
        this.graphicElement.setAlignment(Pos.CENTER);
    }

    public VBox getGraphicElement(){
        return graphicElement;
    }

}
