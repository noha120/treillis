/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.groupe1.treillis;

/**
 *
 * @author nohaa
 */
public class NoeudAppuiSimple extends NoeudAppui{
    
    public NoeudAppuiSimple() {
    }
    
    public NoeudAppuiSimple(double x, double y) {
        super(x, y);
    }
    
     /**
     *
     * @return noeudUser
     */
    @Override
    public NoeudAppuiSimple entreeNoeud() {
        NoeudAppuiSimple noeud = new NoeudAppuiSimple();
        System.out.println("Entrer l'abscisse du noeud.");
        noeud.px = Lire.d();
        System.out.println("Entrer l'ordonnee du noeud.");
        double o = Lire.d();
        System.out.println("Entrer l'abscisse de la force associee au noeud");
        double fx = Lire.d();
        System.out.println("Entrer l'ordonnee de la force associee au noeud");
        double fy = Lire.d();
        Vecteur2D f = new Vecteur2D(fx,fy);
        
        NoeudAppuiSimple noeudUser = new NoeudAppuiSimple(a,o);
        return  noeudUser;
    }
    
}
