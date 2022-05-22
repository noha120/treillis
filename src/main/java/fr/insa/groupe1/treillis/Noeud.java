package fr.insa.groupe1.treillis;

/**
 *
 * @author Antoine
 */
public abstract class Noeud {
    
    protected int identificateur;
    protected double px;
    protected double py;
    protected Vecteur2D force;
  
    public Noeud(int id, double x, double y, Vecteur2D f){
        
        this.identificateur=id;
        this.px=x;
        this.py=y;
        this.force=f;
    }
    public Noeud(double x, double y, Vecteur2D f){
        
       this.identificateur=-1;
       this.px=x;
       this.py=y;
       this.force=f;
    }

    public Noeud(double x, double y){
        
       this.identificateur=-1;
       this.px=x;
       this.py=y;
       this.force = new Vecteur2D(0,0);
    }

    /**
     * @return the identificateur
     */
    public int getIdentificateur() {
        return identificateur;
    }

    /**
     * @return the px
     */
    public double getPx () {
        return px;
    }

    /**
     * @return the py
     */
    public double getPy() {
        return py;
    }

    /**
     * @return the force
     */
    public Vecteur2D getForce() {
        return force;
    }

    /**
     * @param identificateur the identificateur to set
     */
    public void setIdentificateur(int identificateur) {
        this.identificateur = identificateur;
    }

    /**
     * @param px the px to set
     */
    public void setPx (double px) {
        this.px = px;
    }

    /**
     * @param py the py to set
     */
    public void setPy(double py) {
        this.py = py;
    }

    /**
     * @param force the force to set
     */
    public void setForce(Vecteur2D force) {
        this.force = force;
    }
    
    /**
     *
     * @return noeud with identifacteur, px py and force
     */
    @Override
    public String toString(){
        return("Noeud " + this.identificateur + ": (" + this.px + "," + this.py + ") ; force: "+this.force);
    }  

    /**
     *
     * @param i
     * @return noeudUser
     */
     public static Noeud entreeNoeud(int i){

        System.out.println("Entrer l'abscisse du noeud.");
        double px = Lire.d();
        System.out.println("Entrer l'ordonnee du noeud.");
        double py = Lire.d();
        System.out.println("Entrer l'abscisse de la force associee au noeud");
        double fx = Lire.d();
        System.out.println("Entrer l'ordonnee de la force associee au noeud");
        double fy = Lire.d();
        Vecteur2D f = new Vecteur2D(fx,fy);
      
        //Noeud noeudUser = new Noeud(px,py,f);
        
        switch(i){
            case 1 -> {
               NoeudSimple noeudUser = new NoeudSimple(px,py,f); 
               return noeudUser;
            }
            case 2 ->{
                NoeudAppuiSimple noeudUser = new NoeudAppuiSimple(px,py,f);
                return noeudUser;
            }
            case 3 ->{
                NoeudAppuiDouble noeudUser = new NoeudAppuiDouble(px,py);
                return noeudUser;
            }
        }
        return null;
        
    }
    
    public static void main(String []args){
        
    }
}
