package edu.vanier.ufo.game;

import edu.vanier.ufo.engine.GameEngine;
import edu.vanier.ufo.engine.SoundManager;
import edu.vanier.ufo.engine.Sprite;
import edu.vanier.ufo.helpers.ResourcesManager;
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
     *
     * @param gameWorld - game world
     */
    public void implode(final GameEngine gameWorld) {
        vX = vY = 0;
        Node currentNode = getNode();
        /* TODO: fix this code to add explosing effect*/
        Sprite explosion = new Atom(ResourcesManager.explosion);  
        explosion.getNode().setLayoutX(currentNode.getTranslateX());
        explosion.getNode().setLayoutY(currentNode.getTranslateX());
        gameWorld.getSceneNodes().getChildren().add(explosion.getNode());
        FadeTransition ft = new FadeTransition(Duration.millis(300), currentNode);
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

   
}
