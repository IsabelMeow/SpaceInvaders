package edu.vanier.ufo.game;

import edu.vanier.ufo.engine.GameEngine;
import edu.vanier.ufo.engine.SoundManager;
import edu.vanier.ufo.engine.Sprite;
import edu.vanier.ufo.helpers.ResourcesManager;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * A spherical looking object (Atom) with a random radius, color, and velocity.
 * When two atoms collide each will fade and become removed from the scene. The
 * method called implode() implements a fade transition effect.
 *
 * @author cdea
 */
public class Atom extends Sprite {
    private int health; 
    private int points; 
    private double centerX; 
    private double centerY;
    private List<Atom> atoms; 
    Atom atom;

    
    private void addAtoms (Atom atom){
       atoms.add(atom); 
    }
    
    public List<Atom> getAtoms() {
        return atoms;
    }

    public void setAtoms(List<Atom> atoms) {
        this.atoms = atoms;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    
    
    /**
     * Constructor will create a optionally create a gradient fill circle shape.
     * This sprite will contain a JavaFX Circle node.
     *
     * @param imagePath the path of the image to be embedded in the node object.
     */
    public Atom(String imagePath) {
        ImageView newAtom = new ImageView();
        Image shipImage = new Image(imagePath, true);        
        newAtom.setImage(shipImage);        
        this.node = newAtom;
        this.collidingNode = newAtom;
        
    }

    /**
     * Change the velocity of the current atom particle.
     */
    @Override
    public void update() {
        getNode().setTranslateX(getNode().getTranslateX() + vX);
        getNode().setTranslateY(getNode().getTranslateY() + vY);
    }

    /**
     * Returns a node casted as a JavaFX Circle shape.
     *
     * @return Circle shape representing JavaFX node for convenience.
     */
    public ImageView getImageViewNode() {
        return (ImageView) getNode();
    }

    /**
     * Animate an implosion. Once done remove from the game world
     * @param gameWorld - game world
     * Two different implode methods were implemented in order to fix the bug:
     * -Explosion effect appeared twice
     */
    
    public void implodeWtihExplosion(final GameEngine gameWorld) {
        vX = vY = 0;
        Node currentNode = getNode();
        
        //TODO: fix this code to add explosing effect
        
        Image explosionImage = new Image(ResourcesManager.explosion, 90d, 90d, true, true);
        ImageView explosionAnimation = new ImageView(explosionImage);
        
        Group groupOfExplosion = new Group(explosionAnimation);
    
        groupOfExplosion.setLayoutX(currentNode.getTranslateX());
        groupOfExplosion.setLayoutY(currentNode.getTranslateY());
        gameWorld.getSceneNodes().getChildren().add(groupOfExplosion);
        
        
        FadeTransition ft = new FadeTransition(Duration.millis(150), currentNode);
        ft.setFromValue(vX);
        ft.setToValue(0);
        ft.setOnFinished((ActionEvent event) -> {
            isDead = true;
            gameWorld.getSceneNodes().getChildren().remove(currentNode);
            
        });
        ft.play();
        
    }
    
    /**
     * Removes sprites without doing an explosion
     *
     * @param gameWorld - game world
     */
    
    public void implode(final GameEngine gameWorld) {
        vX = vY = 0;
        Node currentNode = getNode();
              
        FadeTransition ft = new FadeTransition(Duration.millis(150), currentNode);
        ft.setFromValue(vX);
        ft.setToValue(0);
        ft.setOnFinished((ActionEvent event) -> {
            isDead = true;
            gameWorld.getSceneNodes().getChildren().remove(currentNode);
            
        });
        ft.play();
        
    }
   

    @Override
    public void handleDeath(GameEngine gameWorld) {
        implode(gameWorld);
        super.handleDeath(gameWorld);
    }
    
    @Override
    public void handleDeathWithExplosion(GameEngine gameWorld) {
        implodeWtihExplosion(gameWorld);
        super.handleDeath(gameWorld);
    }

   
}
