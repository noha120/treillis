/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.groupe1.treillis.gui;

import fr.insa.groupe1.treillis.gui.DessinCanvas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author nohaa
 */
public class MainPane extends BorderPane {
    
    private Button bSelect;
    private Button bNoeud;
    private Button bBarre;
    
    private Button bGrouper;
    private Button bCouleur;
    
    private DessinCanvas cDessin;
    
    public MainPane(){
        this.bSelect = new Button("Select");
        this.bNoeud = new Button("Noeud");
        this.bBarre = new Button("Barre");
        
        VBox vbGauche = new VBox(this.bSelect,this.bNoeud,this.bBarre);
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
