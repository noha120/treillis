package fr.insa.groupe1.treillis;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import recup.Lire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Groupe extends Figure{

    private List<Figure> contient;

    public List<Figure> getContient() {
        return contient;
    }

    public Groupe() {
        this.contient = new ArrayList<Figure>();
    }

    public void add(Figure f){
        if (f.getGroupe() != this){
            if (f.getGroupe() != null){
                throw new Error("figure deja dans un autre groupe");
            }

            this.contient.add(f);
            f.setGroupe(this);
        }
    }

    public void remove(Figure f) {
        if (f.getGroupe() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.contient.remove(f);
        f.setGroupe(null);
    }

    public void removeAll(List<Figure> lf) {
        for (Figure f : lf) {
            this.remove(f);
        }
    }

    public void clear() {
        List<Figure> toRemove = new ArrayList<>(this.contient);
        this.removeAll(toRemove);
    }

    public int size() {
        return this.contient.size();
    }

    public Figure plusProche(NoeudSimple N, double distMax) {
        if (this.contient.isEmpty()) {
            return null;
        } else {
            Figure fmin = this.contient.get(0);
            double min = fmin.distanceNoeud(N);
            for (int i = 1; i < this.contient.size(); i++) {
                Figure fcur = this.contient.get(i);
                double cur = fcur.distanceNoeud(N);
                if (cur < min) {
                    min = cur;
                    fmin = fcur;
                }
            }
            if (min <= distMax) {
                return fmin;
            } else {
                return null;
            }
        }
    }

    public Groupe sousGroupe(List<Figure> lf) {
        // verifie que les figures font actuellement partie du groupe
        // et les enleve du groupe
        for (int i = 0; i < lf.size(); i++) {
            Figure f = lf.get(i);
            if (f.getGroupe() != this) {
                throw new Error(f + " n'appartient pas au groupe " + this);
            }
            this.contient.remove(f);
            f.setGroupe(null);
        }
        Groupe sg = new Groupe();
        for (int i = 0; i < lf.size(); i++) {
            sg.add(lf.get(i));
        }
        this.add(sg);
        return sg;
    }

    public static String indente(String toIndente, String prefix) {
        return prefix + toIndente.replaceAll("\n", "\n" + prefix);
    }

    public Noeud choisiNoeud() {
        List<Noeud> ln =new ArrayList<>();
        System.out.println("Liste des noeuds disponibles");
        int nbr = 0;
        for (int i = 0; i < this.contient.size(); i++){
            Figure f = this.contient.get(i);
            if ( f instanceof Noeud){
                nbr++;
                ln.add((Noeud) f);
                System.out.println(nbr + ") " + f);

            }
        }
        if (nbr == 0){
            System.out.println("Aucun noeud disponible");
            return null;
        } else {
            int rep = -1;
            while (rep < 0 || rep > nbr) {
                System.out.println("Votre choix (saisissez 0 pour annnuler) :");
                rep = Lire.i();
            }
            if ( rep == 0) {
                return null;
            } else {
                return ln.get(rep - 1);
            }
        }
    }

    public List<Figure> choisiFigures() {
        List<Figure> res = new ArrayList<>();
        int rep = -1;
        while (rep != 0) {
            System.out.println("liste des figures disponibles : ");
            for (int i = 0; i < this.contient.size(); i++) {
                System.out.println((i + 1) + ") " + this.contient.get(i));
            }
            System.out.println("votre choix (0 pour finir) : ");
            rep = Lire.i();
            if (rep > 0 && rep <= this.contient.size()) {
                Figure f = this.contient.get(rep - 1);
                if (res.contains(f)) {
                    System.out.println("déja selectionnée");
                } else {
                    res.add(f);
                }
                System.out.println(res.size() + " figure(s) séléctionnée(s)");
            }
        }
        return res;
    }
    @Override
    public String toString() {
        String res = "Groupe {\n";
        for (int i = 0; i < this.contient.size(); i++) {
            res = res + indente(this.contient.get(i).toString(), "  ") + "\n";
        }
        return res + "}";
    }

    public static Groupe groupeTest() {
        NoeudSimple N1 = new NoeudSimple(10, 10);
        NoeudSimple N2 = new NoeudSimple(100, 10);
        NoeudSimple N3 = new NoeudSimple(100, 100);
        NoeudSimple N4 = new NoeudSimple(10, 100);
        NoeudSimple N5 = new NoeudSimple(50, 50);
        NoeudSimple N6 = new NoeudSimple(500, 500);
        Barre B1 = new Barre(N1, N2, Color.color(Math.random(), Math.random(), Math.random()));
        Barre B2 = new Barre(N2, N3, Color.color(Math.random(), Math.random(), Math.random()));
        Barre B3 = new Barre(N3, N1, Color.color(Math.random(), Math.random(), Math.random()));
        Barre B4 = new Barre(N1, N4, Color.color(Math.random(), Math.random(), Math.random()));
        Groupe triangle = new Groupe();
        triangle.add(B1);
        triangle.add(B2);
        triangle.add(B3);
        Groupe res = new Groupe();
        res.add(N5);
        res.add(N6);
        res.add(B4);
        res.add(triangle);
        return res;
    }

    public void menuTexte() {
        int rep = -1;

        while (rep != 0) {
            System.out.println("Gestion textuelle d'un groupe de figure");
            System.out.println("---------------------------------------");
            System.out.println("1) afficher le groupe");
            System.out.println("2) ajouter un point");
            System.out.println("3) ajouter un segment avec deux nouveaux points");
            System.out.println("4) ajouter un segment sur deux points existants");
            System.out.println("5) créer un sous-groupe");
            System.out.println("6) afficher le rectangle englobant");
            System.out.println("7) calculer la distance à un point");
            System.out.println("8) retirer des figures du groupe");
            // System.out.println("9) sauvegarder le groupe dans un fichier");
            System.out.println("0) quitter");
            System.out.println("votre choix : ");

            rep = Lire.i();

            if (rep == 1) {
                System.out.println(this);
            } else if (rep == 2) {
                var np = Noeud.entreeNoeud();
                this.add(np);
            } else if (rep == 3) {
                Barre ns = Barre.entreeBarre();
                this.add(ns);
            } else if (rep == 4) {
                System.out.println("choisissez le début du segment");
                Noeud Ndebut = this.choisiNoeud();
                if (Ndebut != null) {
                    System.out.println("choisissez la fin du segment");
                    Noeud Nfin = this.choisiNoeud();
                    Barre ns = new Barre(Ndebut, Nfin);
                    this.add(ns);
                }
            } else if (rep == 5) {
                List<Figure> select = this.choisiFigures();
                this.sousGroupe(select);
            } else if (rep == 6) {
                System.out.println("maxX = " + this.getMaxX() + " ; "
                        + "minX = " + this.getMinX() + "\n"
                        + "maxY = " + this.getMaxY() + " ; "
                        + "minY = " + this.getMinY() + "\n");
            } else if (rep == 7) {
                System.out.println("entrez un point :");
                Noeud p = Noeud.entreeNoeud();
                System.out.println("distance : " + this.distanceNoeud(p));
            } else if (rep == 8) {
                List<Figure> select = this.choisiFigures();
                this.removeAll(select);}
//                else if (rep == 9) {
//                System.out.println("répertoire courant : ");
//                System.out.println(System.getProperty("user.dir"));
//                System.out.println("entrez le chemin du fichier où sauvegarder le groupe de figure : ");
//                String path = Lire.S();
//                File fout = new File(path);
//                try {
//                    this.sauvegarde(fout);
//                } catch (FileNotFoundException ex) {
//                    System.out.println("fichier non trouvé : " + fout.getAbsolutePath());;
//                } catch (IOException ex) {
//                    System.out.println("problème de lecture : " + ex.getLocalizedMessage());;
//                }
//
//            }
        }
    }

    public static void testMenu() {
        Groupe g = groupeTest();
        g.menuTexte();
    }

    public static void test1() {
        System.out.println("groupe test : \n" + Groupe.groupeTest());
    }

    public static void main(String[] args){
        // test1();
        // testMenu();
    }

    @Override
    public double getMaxX() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double max = this.contient.get(0).getMaxX();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).getMaxX();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }

    @Override
    public double getMinX() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double min = this.contient.get(0).getMinX();
            for (int i = 1; i < this.contient.size(); i++){
                double cur = this.contient.get(i).getMinX();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }

    @Override
    public double getMinY() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double min = this.contient.get(0).getMinY();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).getMinY();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }

    @Override
    public double getMaxY() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double max = this.contient.get(0).getMaxY();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).getMaxY();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }

    @Override
    public void dessine(GraphicsContext context) {
        for(Figure f : this.contient) {
            f.dessine(context);
        }
    }

    @Override
    public double distanceNoeud(Noeud N) {
        return 0;
    }

    @Override
    public void dessineSelection(GraphicsContext context) {

    }

    @Override
    public void changeCouleur(Color value) {

    }

}