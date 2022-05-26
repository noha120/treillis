package fr.insa.groupe1.treillis;

import java.lang.Math;
import java.util.UUID;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Antoine
 */
public class Barre extends FigureSimple {
    
    protected UUID id;
    protected Noeud NDebut;
    protected Noeud NFin;
    protected double resistance;
    
    public Barre (Noeud NDebut, Noeud NFin, Color couleur){
        super(couleur);
        this.id = UUID.randomUUID();
        this.NDebut = NDebut;
        this.NFin = NFin;

        NDebut.barresDepart.add(this);
        NFin.barresArrivee.add(this);
    }

    public Barre (Noeud NDebut, Noeud NFin){
        this.id = UUID.randomUUID();
        this.NDebut = NDebut;
        this.NFin = NFin;

        NDebut.barresDepart.add(this);
        NFin.barresArrivee.add(this);
    }

    public Noeud getDebut(){
        return this.NDebut;
    }
    
    public Noeud getFin(){
        return this.NFin;
    }
    
    public UUID getId(){
        return this.id;
    }
    
    public void setId(UUID id){
        this.id = id;
    }
    
    public double getMaxX(){
        return Math.max(this.NDebut.getPx(),this.NFin.getPx());
    }
    
    public double getMinX(){
        return Math.min(this.NDebut.getPx(),this.NFin.getPx());
    }
    
    public double getMaxY(){
        return Math.max(this.NDebut.getPy(),this.NFin.getPy());
    }
    
    public double getMinY(){
        return Math.min(this.NDebut.getPy(),this.NFin.getPy());
    }
    
    
    public String toString(){
        return ("["+this.NDebut + " ; "+ this.NFin + "]");
    }
    
    public double dist(Barre barre){
        double MX = barre.getMaxX();
        double mX = barre.getMinX();
        double MY = barre.getMaxY();
        double mY = barre.getMinY();
        return Math.sqrt(Math.pow(MX-mX,2)+Math.pow(MY-mY,2));
    }

    @Override
    public void dessine(GraphicsContext context) {
        context.setStroke(this.getCouleur());
        context.strokeLine(this.NDebut.getPx(), this.NDebut.getPy(), this.NFin.getPx(), this.NFin.getPy());
    }

    @Override
    public double distanceNoeud(Noeud N) {
        double x1 = this.NDebut.getPx();
        double y1 = this.NDebut.getPy();
        double x2 = this.NFin.getPx();
        double y2 = this.NFin.getPy();
        double x3 = N.getPx();
        double y3 = N.getPy();
        double up = ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1))
                / (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (up < 0) {
            return this.NDebut.distanceNoeud(N);
        } else if (up > 1) {
            return this.NFin.distanceNoeud(N);
        } else {
            NoeudSimple N4 = new NoeudSimple(x1 + up * (x2 - x1), y1 + up * (y2 - y1));
            return N4.distanceNoeud(N);
        }
    }

    public static Barre entreeBarre() {
        System.out.println("point début : ");
        var deb = NoeudSimple.entreeNoeud();
        System.out.println("point fin : ");
        var fin = NoeudSimple.entreeNoeud();
        return new Barre(deb, fin, Color.BLACK);
    }
    
    public double angle(Barre barre){
        var N1 = barre.getDebut();
        var N2 = barre.getFin();

        var O = new NoeudSimple(500,Math.min(N1.getPy(),N2.getPy()));
        Barre OA = new Barre (O, N1, Color.color(Math.random(), Math.random(), Math.random()));
        Barre OB = new Barre(O, N2, Color.color(Math.random(), Math.random(), Math.random()));
        return Math.acos((N1.px-O.px)*(N2.px-O.px)+(N1.py-O.py)*(N2.py-O.py)/(dist(OA)*dist(OB)));
    }
    
}