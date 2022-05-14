/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.abouhamdan.treillis;

/**
 *
 * @author nohaa
 */
public class Vecteur2D {
    
    private double vx;
    private double vy;
        
    public Vecteur2D(double x, double y){
        this.vx=x;
        this.vy=y;
    }
        
    /**
     * @return the vx
     */
    public double getVx () {
        return this.vx;
    }
        
    /**
     * @return the vy
     */
    public double getVy() {
        return this.vy;
    }
        
    /**
     * @param vx the vx to set
     */
    public void setVx (double vx) {
        this.vx = vx;
    }

    /**
     * @param vy the vy to set
     */
    public void setVy(double vy) {
        this.vy = vy;
    }
    
  
    /**
     * 
     * @return (vx,vy)
     */
    @Override
    public String toString(){
        return "(" + this.vx + "," + this.vy + ")";
    }
}
