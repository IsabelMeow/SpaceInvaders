/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vanier.ufo.ui;

import edu.vanier.ufo.game.Ship;
import edu.vanier.ufo.helpers.ResourcesManager;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

/**
 *
 * @author nguye
 */
public class LevelSettings {
    
    private int levelNumber;
    private Ship ship;
    private Label score;
    private int nbOfInvaders; 
  

    ResourcesManager RM = new ResourcesManager(); 
    
    
    /**
     * Change the ship imageView depending on the level
     *
     */
    public Ship generateShip(){
    
        switch (this.getLevelNumber()) {
            case 1:
                this.ship.changeShip((ResourcesManager.SS1));
                return this.getShip();
            case 2:
                this.ship.changeShip((ResourcesManager.SS2));
                return this.getShip();
            case 3:
                this.ship.changeShip((ResourcesManager.SS3));
                return this.getShip();
            case 4:
                this.ship.changeShip((ResourcesManager.SS4));
                return this.getShip();
            default:
                break;
        }

        return null; 
    }
    
    
    public LevelSettings(int levelNumber, int nbOfInvaders) {
        this.levelNumber = levelNumber;
        this.nbOfInvaders = nbOfInvaders;
        this.setShip(generateShip());
    }

  

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    public Label getScore() {
        return score;
    }

    public void setScore(Label score) {
        this.score = score;
    }

    public int getNbOfInvaders() {
        return nbOfInvaders;
    }

    public void setNbOfInvaders(int nbOfInvaders) {
        this.nbOfInvaders = nbOfInvaders;
    }
    

    
}
