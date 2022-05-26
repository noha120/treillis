package fr.insa.groupe1.treillis;


import java.io.FileWriter;
import java.io.IOException;

public class Sauvegarde {

    public Sauvegarde(){
    }

    public void savetreillis(Treillis treillis) throws IOException{
        FileWriter wrb = new FileWriter("SaveBarres");
        for (int i=0;i<treillis.barres.size();i++) {
            wrb.write( treillis.barres.get(i).toString());
        }
        FileWriter wrn = new FileWriter("SaveNoeuds");
        for (int i=0;i<treillis.noeuds.size();i++) {
            wrn.write( treillis.noeuds.get(i).toString());
        }
    }

}
