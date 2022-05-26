package fr.insa.groupe1.treillis;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PublicKey;

public abstract class Figure {

    public static Color COULEUR_SELECTION = Color.LIGHTGREEN;

    private Groupe groupe;

    public Groupe getGroupe() {
        return groupe;
    }

    public abstract void dessine(GraphicsContext context);

    void setGroupe(Groupe groupe){
        this.groupe = groupe;
    }

    public abstract double distanceNoeud(Noeud N);

    public abstract void dessineSelection(GraphicsContext context);

    public abstract void changeCouleur(Color value);

    public abstract double getMaxX();

    public abstract double getMinX();

    public abstract double getMaxY();

    public abstract double getMinY();




}
