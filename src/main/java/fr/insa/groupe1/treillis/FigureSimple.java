package fr.insa.groupe1.treillis;

import javafx.scene.paint.Color;

public abstract class FigureSimple extends Figure {

    private Color couleur;

    public FigureSimple(Color couleur) {this.couleur = couleur; }

    protected FigureSimple() {
    }

    public Color getCouleur(){ return couleur; }

    public void setCouleur(Color couleur) { this.couleur = couleur; }

    // @Override
    public void changeCouleur(Color value) { this.setCouleur(value); }

    public static String saveColor(Color c) { return c.getRed()+";"+c.getGreen()+";"+c.getBlue(); }
    public static Color parseColor(String sr, String sg, String sb) {
        double rouge = Double.parseDouble(sr);
        double vert = Double.parseDouble(sg);
        double bleu = Double.parseDouble(sb);
        return javafx.scene.paint.Color.color(rouge, vert, bleu);
    }

}
