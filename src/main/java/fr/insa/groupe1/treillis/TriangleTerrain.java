package fr.insa.groupe1.treillis;

import java.util.ArrayList;
import java.awt.event.MouseEvent;

/**
 *
 * @author Antoine
 */
public class TriangleTerrain {
    protected ArrayList<NoeudSimple> T1;
    protected ArrayList<NoeudSimple> T2;
    
    
    public void TT(MouseEvent e){
        double x = e.getX();
        double y = e.getY();
        NoeudSimple N1 = new NoeudSimple(x,y);
        NoeudSimple N2 = new NoeudSimple(x+200,y);
        NoeudSimple N3 = new NoeudSimple(x,y+100);
        T1.add(N1);
        T1.add(N2);
        T1.add(N3);
        NoeudSimple N4 = new NoeudSimple(x+500,y);
        NoeudSimple N5 = new NoeudSimple(x+300,y);
        NoeudSimple N6 = new NoeudSimple(x+500,y+100);
        T2.add(N4);
        T2.add(N5);
        T2.add(N6);
        
    }
}