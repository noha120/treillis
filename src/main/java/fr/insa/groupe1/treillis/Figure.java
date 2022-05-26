package fr.insa.groupe1.treillis;

import javafx.scene.canvas.GraphicsContext;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Figure {

    private Groupe groupe;

    public Groupe getGroupe() {
        return groupe;
    }

    public abstract void dessine(GraphicsContext context);

    void setGroupe(Groupe groupe){
        this.groupe = groupe;
    }

    public abstract double distanceNoeud(Noeud N);

    public abstract double getMaxX();

    public abstract double getMinX();

    public abstract double getMaxY();

    public abstract double getMinY();


}
