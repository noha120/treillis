package fr.insa.groupe1.treillis;

import javafx.scene.paint.Color;

/**
 *
 * @author Antoine
 */
public abstract class NoeudAppui extends Noeud{
    
    public NoeudAppui(double x, double y, Color couleur) {
        super(x, y, couleur);
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