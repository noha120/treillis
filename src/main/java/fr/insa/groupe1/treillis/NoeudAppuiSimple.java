package fr.insa.groupe1.treillis;

/**
 *
 * @author Antoine
 */
public class NoeudAppuiSimple extends NoeudAppui{
    
    public NoeudAppuiSimple() {
    }
    
    public NoeudAppuiSimple(double x, double y) {
        super(x, y);
    }
    
    public NoeudAppuiSimple (double x, double y,Vecteur2D f){
        this.px=x;
        this.py=y;
        this.force=f;
    }
    
}