package fr.insa.groupe1.treillis.gui;

import fr.insa.groupe1.treillis.Groupe;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class APP extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new MainPane(stage, new Groupe()), 800, 600);
        stage.setTitle("Interface");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}