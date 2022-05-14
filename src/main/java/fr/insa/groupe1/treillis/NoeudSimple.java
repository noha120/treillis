/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.groupe1.treillis;

/**
 *
 * @author nohaa
 */
public class NoeudSimple extends Noeud{
    
    private int identificateur;
    private double px;
    private double py;
    private Vecteur2D force;
    
    public NoeudSimple(int id, double x, double y, Vecteur2D f){
        
        this.identificateur=id;
        this.px=x;
        this.py=y;
        this.force=f;
    }
    
    @Override
    public Noeud entreeNoeud(){
        
        System.out.println("Entrer l'abscisse du noeud.");
        this.setPx(Lire.d());
        System.out.println("Entrer l'ordonnee du noeud.");
        this.setPy(Lire.d());
        System.out.println("Entrer l'abscisse de la force associee au noeud");
        this.setVx(Lire.d());
        System.out.println("Entrer l'ordonnee de la force associee au noeud");
        this.setVy(Lire.d());
        Vecteur2D f = new Vecteur2D(fx,fy);
        
        Noeud noeudUser = new Noeud(px,py,f);
        return  noeudUser;
    }
}

