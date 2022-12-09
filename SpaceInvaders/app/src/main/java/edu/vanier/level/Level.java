/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vanier.level;

import edu.vanier.ufo.game.Ship;
import edu.vanier.ufo.ui.GameWorld;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author nguye
 */
public class Level extends GameWorld {

    private Scene scene;
    private double levelNumber;
    private Ship ship;
    private Label levelLabel;
    private Label lifeRemaining;
    private Label score;

    public Level(int fps, String title) {
        super(fps, title);
    }

    public void initialize() {
        scene.setFill(Color.BLACK);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(levelLabel, lifeRemaining, score);
        this.generateShip();

    }

    public Ship generateShip() {
        return ship;
    }
}
