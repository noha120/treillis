package fr.insa.groupe1.treillis;

import java.util.ArrayList;

/**
 *
 * @author Antoine
 */
public class Treillis {
    protected ArrayList<Barre> barres;
    protected ArrayList<Noeud> noeuds;
    
    public Treillis (){
        
    }
    
    public ArrayList<Barre> getListeBarres(){
        return barres;
    }
    
    public ArrayList<Noeud> getListeNoeuds(){
        return noeuds;
    }
    
    public void setListeBarres(ArrayList<Barre> listebarres){
        this.barres=listebarres;
    }
    
    public void setListeNoeuds(ArrayList<Noeud> listenoeuds){
        this.noeuds=listenoeuds;
    }
    
    /**
     *
     */
    @Override
    public String toString(){
         for (int i=0;i<this.barres.size();i++){
             System.out.println("["+ this.barres.get(i)+ "]");
         }
         for (int i=0;i<this.noeuds.size();i++){
             System.out.println("["+ this.noeuds.get(i)+ "]");
         }
         return null;
    }
    
    public int maxIdNoeuds(){
        int Mn=-1;
        for (int i=0;i<this.noeuds.size();i++){
             if (this.noeuds.get(i).identificateur>Mn){
                 Mn=this.noeuds.get(i).identificateur;
             }
         }
        return Mn;
    }
    
    public int maxIdBarres(){
        int Mb=-1;
        for (int i=0;i<this.barres.size();i++){
             if (this.barres.get(i).identificateur>Mb){
                 Mb=this.barres.get(i).identificateur;
             }
         }
        return Mb;
    }
    
    public void ajouteBarre(Barre b){
        int t=0;
        for (int i=0;i<this.barres.size();i++){
             if (this.barres.get(i)==b){
                 t=1;
             }
         }
        if(t!=1){
            b.identificateur=maxIdBarres()+1;
            barres.add(b);
            
        }
        else{
            System.out.println("La barre existe deja");
        }
    }
    
    public void ajouteNoeud(NoeudSimple n){
        int t=0;
        for (int i=0;i<this.noeuds.size();i++){
             if (this.noeuds.get(i)==n){
                 t=1;
             }
         }
        if(t!=1){
            n.identificateur=maxIdNoeuds()+1;
            noeuds.add(n);
            
        }
        else{
            System.out.println("Le noeud existe deja");
        }
    }
}