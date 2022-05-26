/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.groupe1.treillis.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;


/**
 *
 * @author nohaa
 */
public class MainPane extends BorderPane {
    
    private RadioButton rbSelect;
    private RadioButton rbNoeud;
    private RadioButton rbBarre;
    
    private Button bGrouper;
    private Button bCouleur;
    
    private DessinCanvas cDessin;
    
    public MainPane(){
        this.rbSelect = new RadioButton("Select");
        this.rbNoeud = new RadioButton("Noeud");
        this.rbBarre = new RadioButton("Barre");
        
        VBox vbGauche = new VBox(this.rbSelect,this.rbNoeud,this.rbBarre);
        this.setLeft(vbGauche);
        
        this.bGrouper = new Button("Grouper");
        this.bGrouper.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("bouton Grouper cliqué");
            }
        });
        this.bCouleur = new Button("Couleur");
        VBox vbDroit = new VBox(this.bGrouper,this.bCouleur);
        this.setRight(vbDroit);
        
        this.cDessin = new DessinCanvas();
        this.setCenter(this.cDessin);   
    }

    
}
