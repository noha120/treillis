package fr.insa.groupe1.treillis;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * @author Antoine
 */

public class NoeudAppuiDouble extends NoeudAppui {
    public NoeudAppuiDouble(double x, double y) {
        super(x, y);
    }

    public NoeudAppuiDouble(double x, double y, Color couleur) {
        super(x, y, couleur);

        /*this.px=x;
        this.py=y;
        this.force=f;*/
    }


    @Override
    public double distanceNoeud(Noeud N) {
        return 0;
    }

    @Override
    public void dessineSelection(GraphicsContext context) {
        context.setFill(Figure.COULEUR_SELECTION);
        context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }

    @Override
    public double getMaxX() {
        return this.px;
    }

    @Override
    public double getMinX() {
        return this.px;
    }

    @Override
    public double getMaxY() {
        return this.py;
    }

    @Override
    public double getMinY() {
        return this.py;
    }
}