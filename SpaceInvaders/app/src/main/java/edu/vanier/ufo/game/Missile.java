package edu.vanier.ufo.game;
/**
 * A missile projectile without the radial gradient.
 */
public class Missile extends Atom {
    private int damageHP; 

    public int getDamageHP() {
        return damageHP;
    }

    public void setDamageHP(int damageHP) {
        this.damageHP = damageHP;
    }
    

    
 
    public Missile(String imagePath) {        
        super(imagePath);
    }
    
}
