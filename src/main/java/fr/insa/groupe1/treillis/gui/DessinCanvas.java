/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.groupe1.treillis.gui;

import fr.insa.groupe1.treillis.Barre;
import fr.insa.groupe1.treillis.Figure;
import fr.insa.groupe1.treillis.Groupe;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

import java.util.List;

/**
 *
 * @author nohaa
 */
public class DessinCanvas extends Pane {

    private MainPane main;

    private Canvas realCanvas;

    // private RectangleHV asRect;
    
    public DessinCanvas(MainPane main){
        this.main = main;
        this.realCanvas = new Canvas(this.getWidth(),this.getHeight());
        this.getChildren().add(this.realCanvas);
        this.realCanvas.heightProperty().bind(this.heightProperty());
        this.realCanvas.heightProperty().addListener((o) -> {
            this.redrawAll();
        });
        this.realCanvas.widthProperty().bind(this.widthProperty());
        this.realCanvas.widthProperty().addListener((o) -> {
           this.redrawAll();
        });
        this.realCanvas.setOnMouseClicked((t) -> {
            Controleur control = this.main.getControleur();
            control.clicDansZoneDessin(t);
        });
        this.redrawAll();
    }

    public Transform getTransform() {
        return this.realCanvas.getGraphicsContext2D().getTransform();
    }

    public void redrawAll(){
        GraphicsContext context = this.realCanvas.getGraphicsContext2D();
        Groupe model = this.main.getModel();
        model.dessine(context);
        List<Figure> select = this.main.getControleur().getSelection();
        if (! select.isEmpty()) {
            for (Figure f : select) {
                f.dessineSelection(context);
            }
        }
        Barre enCours = this.main.getControleur().getBarreEnCoursDeCreation();
        if (enCours != null) {
            context.setLineDashes(1, 1);
            enCours.dessine(context);
            context.setLineDashes(null);
        }
    }
}

//    GraphicsContext context = this.realCanvas.getGraphicsContext2D();
//        context.setTransform(new Affine());
//                context.clearRect(0, 0, this.realCanvas.getWidth(), this.realCanvas.getHeight());
//                this.asRect.setxMax(this.realCanvas.getWidth());
//                this.asRect.setyMax(this.realCanvas.getHeight());
//                Transform curTrans = this.main.getZoneModelVue().fitTransform(this.asRect);
//                this.setTransform(curTrans);
//                Groupe model = this.main.getModel();
//                model.dessine(context);
//                List<Figure> select = this.main.getControleur().getSelection();
//        if (! select.isEmpty()) {
//        for (Figure f : select) {
//        f.dessineSelection(context);
//        }
//        }
//        Barre enCours = this.main.getControleur().getBarreEnCoursDeCreation();
//        if (enCours != null) {
//        context.setLineDashes(1, 1);
//        enCours.dessine(context);
//        context.setLineDashes(null);