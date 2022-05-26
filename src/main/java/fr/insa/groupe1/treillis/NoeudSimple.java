package fr.insa.groupe1.treillis;

import javafx.scene.paint.Color;
/**
 *
 * @author Antoine
 */
       
public class NoeudSimple extends Noeud{
    
    public NoeudSimple(double x, double y){
        super(x,y);
    }
    
    public NoeudSimple(double x, double y, Color couleur){
        super(x, y, couleur);

        /*
        this.identificateur=-1;
        this.px=x;
        this.py=y;
        this.force=f;
        */
    }

    @Override
    public double distanceNoeud(Noeud N) {
        return 0;
    }

    @Override
    public double getMaxX() {
        return 0;
    }

    @Override
    public double getMinX() {
        return 0;
    }

    @Override
    public double getMaxY() {
        return 0;
    }

    @Override
    public double getMinY() {
        return 0;
    }
}