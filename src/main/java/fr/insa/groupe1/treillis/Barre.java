package fr.insa.groupe1.treillis;

import java.lang.Math;


/**
 *
 * @author Antoine
 */
public class Barre {
    
    protected NoeudSimple NDebut;
    protected NoeudSimple NFin;
    protected int identificateur;
    protected double resistance;
    
    public Barre (NoeudSimple NDebut,NoeudSimple NFin){
    this.NDebut=NDebut;
    this.NFin=NFin;
    Barre B=new Barre(NDebut,NFin);
    NDebut.barresDepart.add(B);
    NFin.barresArrivee.add(B);
    }
    
    public NoeudSimple getDebut(){
        return this.NDebut;
    }
    
    public NoeudSimple getFin(){
        return this.NFin;
    }
    
    public int getId(){
        return this.identificateur;
    }
    
    public void setId(int id){
        this.identificateur=id;
    }
    
    public double getMaxX(){
        return Math.max(this.NDebut.getPx(),this.NFin.getPx());
    }
    
    public double getMinX(){
        return Math.min(this.NDebut.getPx(),this.NFin.getPx());
    }
    
    public double getMaxY(){
        return Math.max(this.NDebut.getPy(),this.NFin.getPy());
    }
    
    public double getMinY(){
        return Math.min(this.NDebut.getPy(),this.NFin.getPy());
    }
    
    
    public String toString(){
        return ("["+this.NDebut + " ; "+ this.NFin + "]");
    }
    
    public double dist(Barre barre){
        double MX = barre.getMaxX();
        double mX = barre.getMinX();
        double MY = barre.getMaxY();
        double mY = barre.getMinY();
        return Math.sqrt(Math.pow(MX-mX,2)+Math.pow(MY-mY,2));
    }
    
    public double angle(Barre barre){
        NoeudSimple A = barre.getDebut();
        NoeudSimple B = barre.getFin();
        NoeudSimple O = new NoeudSimple(500,Math.min(A.getPy(),B.getPy()));
        Barre OA = new Barre (O,A);
        Barre OB = new Barre(O,B);
        return Math.acos((A.px-O.px)*(B.px-O.px)+(A.py-O.py)*(B.py-O.py)/(dist(OA)*dist(OB)));
    }
    
}