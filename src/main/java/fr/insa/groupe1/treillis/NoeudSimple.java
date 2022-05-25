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
        /*
        this.identificateur=-1;
        this.px=x;
        this.py=y;
        this.force=f;
        */
    }
    
    public NoeudSimple(int id, double x, double y, Vecteur2D f){
        super(id,x,y,f);
        
        /*this.identificateur=id;
        this.px=x;
        this.py=y;
        this.force=f;*/
    }
    
   

   
}