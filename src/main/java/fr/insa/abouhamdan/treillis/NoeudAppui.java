/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.abouhamdan.treillis;

/**
 *
 * @author nohaa
 */
public abstract class NoeudAppui extends Noeud{

    public NoeudAppui(double x, double y) {
        super(x, y);
    }

    /**
     *
     * @return noeudAppuiUser
     */
    @Override
    public NoeudAppui entreeNoeud() {
        System.out.println("Entrer l'abscisse du noeud.");
        this.setPx(Lire.d());
        System.out.println("Entrer l'ordonnee du noeud.");
        this.setPy(Lire.d());
        System.out.println("Entrer l'abscisse de la force associee au noeud");
        double fx = Lire.d();
        System.out.println("Entrer l'ordonnee de la force associee au noeud");
        double fy = Lire.d();
        Vecteur2D f = new Vecteur2D(fx,fy);
        
        NoeudAppui noeudUser = new NoeudAppui();
        return  noeudUser;
    }
    
}