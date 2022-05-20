/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.groupe1.treillis;

/**
 *
 * @author nohaa
 */
public abstract class Noeud {
    
    private int identificateur;
    private double px;
    private double py;
    private Vecteur2D force;
  
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
     * @return noeudUser
     */
     public abstract Noeud entreeNoeud();

    /*    System.out.println("Entrer l'abscisse du noeud.");
        this.px = Lire.d();
        System.out.println("Entrer l'ordonnee du noeud.");
        this.py = Lire.d();
        System.out.println("Entrer l'abscisse de la force associee au noeud");
        double fx = Lire.d();
        System.out.println("Entrer l'ordonnee de la force associee au noeud");
        double fy = Lire.d();
        Vecteur2D f = new Vecteur2D(fx,fy);
        
        Noeud noeudUser = new Noeud(px,py,f);
        return  noeudUser;
    }
    */
    public static void main(String []args){
        
    }
}
