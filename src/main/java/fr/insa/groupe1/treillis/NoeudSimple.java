package fr.insa.groupe1.treillis;
/**
 *
 * @author Antoine
 */
public class NoeudSimple extends Noeud{
    
    public NoeudSimple(double x, double y){
        super(x,y);
    }
    
    public NoeudSimple(double x, double y, Vecteur2D f){
        super(x,y,f);
    }
    
    public NoeudSimple(int id, double x, double y, Vecteur2D f){
        super(id,x,y,f);
    }
    
    public double getX(){
        return this.px;
    }
  
}