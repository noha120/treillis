package fr.insa.groupe1.treillis;

import javafx.scene.canvas.GraphicsContext;
import recup.Lire;

import java.util.ArrayList;
import java.util.UUID;

import javafx.scene.paint.Color;

/**
 * @author Antoine
 */
public abstract class Noeud extends FigureSimple {

    public static double RAYON_IN_DRAW = 5;

    protected UUID id;
    protected double px;
    protected double py;
    public ArrayList<Barre> barresDepart;
    protected ArrayList<Barre> barresArrivee;

    private final NoeudTypeEnum[] noeudTypes = NoeudTypeEnum.values();

    public Noeud(double x, double y, Color couleur) {
        super(couleur);
        this.id = UUID.randomUUID();
        this.px = x;
        this.py = y;
        this.barresDepart = new ArrayList();
        this.barresArrivee = new ArrayList();
    }

    public Noeud(double x, double y) {

        this.id = UUID.randomUUID();
        this.px = x;
        this.py = y;
        this.barresDepart = new ArrayList();
        this.barresArrivee = new ArrayList();
    }


    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the px
     */
    public double getPx() {
        return px;
    }

    /**
     * @return the py
     */
    public double getPy() {
        return py;
    }


    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @param px the px to set
     */
    public void setPx(double px) {
        this.px = px;
    }

    /**
     * @param py the py to set
     */
    public void setPy(double py) {
        this.py = py;
    }

    /**
     * @return noeud with identifacteur, px py and force
     */
    @Override
    public String toString() {
        return "Noeud " + this.id + ": (" + this.px + "," + this.py + ")";
    }

    /**
     * @param
     * @return noeudUser
     */

    public double distanceNoeud(Noeud N) {
        double dx = this.px - N.px;
        double dy = this.py - N.py;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static Noeud entreeNoeud() {
        var types = NoeudTypeEnum.values();

        System.out.println("Entrer l'abscisse du noeud.");
        double px = Lire.d();
        System.out.println("Entrer l'ordonnee du noeud.");
        double py = Lire.d();
        System.out.println("Entrez le type de noeud. 1 pour Noeud Simple, 2 pour Noeud Appui Simple, 3 pour Noeud Appui Double");
        var type = types[Lire.i() + 1];

        Noeud noeudUser;
        switch (type) {
            case Simple -> noeudUser = new NoeudSimple(px, py);
            case AppuiSimple -> noeudUser = new NoeudAppuiSimple(px, py);
            case AppuiDouble -> noeudUser = new NoeudAppuiDouble(px, py);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }

        return noeudUser;
    }


    @Override
    public void dessine(GraphicsContext context) {
        context.setFill(this.getCouleur());
        context.fillOval(this.px - RAYON_IN_DRAW, this.py - RAYON_IN_DRAW, 2 * RAYON_IN_DRAW, 2 * RAYON_IN_DRAW);
    }

    @Override
    public void dessineSelection(GraphicsContext context) {
        context.setFill(Figure.COULEUR_SELECTION);
        context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }

    public void barresIncidnetes(Noeud N) {
        for (int i = 0; i < N.barresArrivee.size(); i++) {
            System.out.println(N.barresArrivee.get(i));
        }
    }

}