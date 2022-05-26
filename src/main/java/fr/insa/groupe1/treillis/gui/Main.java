package fr.insa.groupe1.treillis.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new MainPane(), 800, 600);
        stage.setTitle("Interface");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}