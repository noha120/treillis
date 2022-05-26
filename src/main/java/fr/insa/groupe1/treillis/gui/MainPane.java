/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.groupe1.treillis.gui;

import fr.insa.groupe1.treillis.Groupe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.net.HttpCookie;


/**
 *
 * @author nohaa
 */
public class MainPane extends BorderPane {

    private Groupe model;
    private Controleur controleur;

    private Stage inStage;
    private File curFile;

    private RadioButton rbSelect;
    private RadioButton rbNoeud;
    private RadioButton rbBarre;
    
    private Button bGrouper;
    private ColorPicker cpCouleur;
    
    private DessinCanvas cDessin;

    public MainPane(){
        this(new Groupe());
    }
    public MainPane(Groupe model){
        this.model = model;
        this.controleur = new Controleur(this);

        this.rbSelect = new RadioButton("Select");
        this.rbSelect.setOnAction((t) -> {
            this.controleur.boutonSelect(t);
        });
        this.rbNoeud = new RadioButton("Noeud");
        this.rbNoeud.setOnAction((t) -> {
            this.controleur.boutonNoeud(t);
        });
        this.rbBarre = new RadioButton("Barre");
        this.rbBarre.setOnAction((t) -> {
            this.controleur.boutonBarre(t);
                });

        ToggleGroup bgEtat = new ToggleGroup();
        this.rbSelect.setToggleGroup(bgEtat);
        this.rbNoeud.setToggleGroup(bgEtat);
        this.rbBarre.setToggleGroup(bgEtat);
        this.rbNoeud.setSelected(true);

        VBox vbGauche = new VBox(this.rbSelect,this.rbNoeud,this.rbBarre);
        this.setLeft(vbGauche);
        
        this.bGrouper = new Button("Grouper");
        this.bGrouper.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("bouton Grouper cliqué");
            }
        });
        this.cpCouleur = new ColorPicker(Color.BLACK);
        this.cpCouleur.setOnAction((t) -> {
            System.out.println("cpCouleur");
            this.controleur.changeColor(this.cpCouleur.getValue());
                });
        this.cpCouleur.setOnMouseDragEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                System.out.println("entered couleur en " + t.getX() + "" + t.getY());
            }
        });
        VBox vbDroit = new VBox(this.bGrouper,this.cpCouleur);
        this.setRight(vbDroit);
        
        this.cDessin = new DessinCanvas(this);
        this.setCenter(this.cDessin);
        this.controleur.changeEtat(30);
    }

    public void redrawAll(){
        this.cDessin.redrawAll();
    }

    public Groupe getModel() {
        return model;
    }

    public void setModel(Groupe model) {
        this.model = model;
    }

    public Controleur getControleur() {
        return controleur;
    }

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public RadioButton getRbSelect() {
        return rbSelect;
    }

    public RadioButton getRbNoeud() {
        return rbNoeud;
    }

    public RadioButton getRbBarre() {
        return rbBarre;
    }

    public Button getbGrouper() {
        return bGrouper;
    }

    public ColorPicker changeColor() {
        return cpCouleur;
    }

    public DessinCanvas getcDessin() {
        return cDessin;
    }

    public Stage getInStage() {
        return inStage;
    }

    public File getCurFile() {
        return curFile;
    }

    public void setCurFile(File curFile) {
        this.curFile = curFile;
    }


    public ColorPicker getCpCouleur() {
        return cpCouleur;
    }

//    public RectangleHV getZoneModelVue() {
//        return getZoneModelVue();
//    }
}
