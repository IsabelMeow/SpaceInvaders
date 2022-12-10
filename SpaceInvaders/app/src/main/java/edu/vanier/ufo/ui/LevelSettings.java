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
    
    public Ship generateShip(){
    
        if (this.getLevelNumber() == 1) {
            this.ship = new Ship(new Image(ResourcesManager.SS1)); 
            return this.getShip();
        }
        else if (this.getLevelNumber() == 2) {
            this.ship = new Ship(new Image(ResourcesManager.SS2)); 
            return this.getShip(); 
            
        } else if (this.getLevelNumber() == 3){
            this.ship = new Ship(new Image(ResourcesManager.SS3)); 
            return this.getShip(); 
        } else if (this.getLevelNumber() == 4) {
            this.ship = new Ship (new Image(ResourcesManager.SS4)); 
            return this.getShip(); 
            
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
