package fr.insa.groupe1.treillis;

/**
 *
 * @author Antoine
 */
public abstract class NoeudAppui extends Noeud{
    
    public NoeudAppui(int i, double x, double y,Vecteur2D f) {
        super(i, x, y, f);

    }
    
    public NoeudAppui(double x, double y,Vecteur2D f) {
            super(x, y, f);
    }
    
    public NoeudAppui(double x, double y) {
        super(x, y);
    }
    
    
   
    
    
    /**
     *
     * @return noeudAppuiUser
     */
    //@Override
    //public abstract NoeudAppui entreeNoeud(int i); 
  
    
}