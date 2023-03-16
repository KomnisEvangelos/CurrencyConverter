package com.example.currencyconverter2;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageBox {

    public static  void display (String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label lbl = new Label();
        lbl.setText(message);


        StackPane layout = new StackPane();
        layout.getChildren().add(lbl);
        Scene scene = new Scene(layout,250,150);
        window.setScene(scene);
        window.show();
    }
}
