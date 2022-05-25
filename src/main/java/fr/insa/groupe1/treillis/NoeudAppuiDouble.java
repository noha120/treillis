package fr.insa.groupe1.treillis;

/**
 *
 * @author Antoine
 */
        
public class NoeudAppuiDouble extends NoeudAppui{
    
  
    
    public NoeudAppuiDouble (double x, double y) {
        super(x, y);
    }
    
    public NoeudAppuiDouble (double x, double y,Vecteur2D f){
        super(x,y,f);
        /*this.px=x;
        this.py=y;
        this.force=f;*/
    }
    
    public NoeudAppuiDouble (int i,double x, double y,Vecteur2D f){
        super(i,x,y,f);
        /*this.px=x;
        this.py=y;
        this.force=f;
        this.identificateur=i;*/
    }
    
    
}