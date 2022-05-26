package fr.insa.groupe1.treillis.gui;

import fr.insa.groupe1.treillis.*;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Controleur {

    private MainPane vue;

    private int etat;

    private double[] pos1 = new double[2];

    private Barre barreEnCourDeCreation = null;

    private List<Figure> selection;

    public Controleur(MainPane vue) {
        this.vue = vue;
        this.selection = new ArrayList<>();
    }

    public void changeEtat(int nouvelEtat) {
        if (nouvelEtat == 20) {
            this.vue.getRbSelect().setSelected(true);
            this.selection.clear();
            this.barreEnCourDeCreation = null;
            this.vue.redrawAll();
        } else if (nouvelEtat == 30) {
            // creation de points
            this.vue.getRbNoeud().setSelected(true);
            this.selection.clear();
            this.barreEnCourDeCreation = null;
            this.vue.getbGrouper().setDisable(true);
            this.vue.redrawAll();
        } else if (nouvelEtat == 40) {
            // creation de segments étape 1
            this.vue.getRbBarre().setSelected(true);
            this.selection.clear();
            this.barreEnCourDeCreation = null;
            this.vue.getbGrouper().setDisable(true);
            this.vue.redrawAll();
        } else if (nouvelEtat == 41) {
            // creation de segments étape 2
        }
        this.etat = nouvelEtat;
        this.activeBoutonsSuivantSelection();

    }

    void clicDansZoneDessin(MouseEvent t) {
        if (this.etat == 20) {
            NoeudSimple nclic = new NoeudSimple(t.getX(), t.getY());
            // pas de limite de distance entre le clic et l'objet selectionné
            Figure proche = this.vue.getModel().plusProche(nclic, Double.MAX_VALUE);
            if (proche != null) {
                if (t.isShiftDown()) {
                    this.selection.add(proche);
                } else if (t.isControlDown()) {
                    if (this.selection.contains(proche)) {
                        this.selection.remove(proche);
                    } else {
                        this.selection.add(proche);
                    }
                } else {
                    this.selection.clear();
                    this.selection.add(proche);
                }
                this.activeBoutonsSuivantSelection();
                this.vue.redrawAll();
            }
        } else if (this.etat == 30) {
            double px = t.getX();
            double py = t.getY();
            Color col = this.vue.getCpCouleur().getValue();
            Groupe model = this.vue.getModel();
            model.add(new NoeudSimple(px, py, col));
            this.vue.redrawAll();
            } else if (this.etat == 40) {
                this.pos1[0] = t.getX();
                this.pos1[1] = t.getY();
                this.changeEtat(41);
            } else if ( this.etat == 41){
                double px2 = t.getX();
                double py2 = t.getY();
                Color col = this.vue.getCpCouleur().getValue();
                this.vue.getModel().add(
                        new Barre(new NoeudSimple(this.pos1[0], this.pos1[1]),
                                new NoeudSimple (px2, py2, col)));
                        this.vue.redrawAll();
                        this.changeEtat(40);
            }
            }

    public void boutonSelect(ActionEvent t) {
        this.changeEtat(20);
    }

    public void boutonNoeud(ActionEvent t) {
        this.changeEtat(30);
    }

    public void boutonBarre(ActionEvent t) {
        this.changeEtat(40);
    }

    private void activeBoutonsSuivantSelection() {
        if (this.selection.size() < 2) {
            this.vue.getbGrouper().setDisable(true);
        } else {
            this.vue.getbGrouper().setDisable(false);
        }
    }

    void changeColor(Color value) {
        if (this.etat == 20 && this.selection.size() > 0) {
            for (Figure f : this.selection) {
                f.changeCouleur(value);
            }
            this.vue.redrawAll();
        }
    }

    public List<Figure> getSelection() {
        return selection;
    }

    public Barre getBarreEnCoursDeCreation() {
        return barreEnCourDeCreation;
    }
}

