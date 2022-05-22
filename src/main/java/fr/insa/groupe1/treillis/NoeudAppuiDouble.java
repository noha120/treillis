package fr.insa.groupe1.treillis;

/**
 *
 * @author Antoine
 */
public class NoeudAppuiDouble extends NoeudAppui{
    
    public NoeudAppuiDouble(){
    }
    
    public NoeudAppuiDouble (double x, double y) {
        super(x, y);
    }
    
    public NoeudAppuiDouble (double x, double y,Vecteur2D f){
        this.px=x;
        this.py=y;
        this.force=f;
    }
    
}