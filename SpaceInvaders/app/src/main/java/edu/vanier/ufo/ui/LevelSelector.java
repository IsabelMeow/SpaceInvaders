/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vanier.ufo.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author nguye
 */
public class LevelSelector extends Scene {
    @FXML
    private VBox vBoxLevel1, vBoxLevel2, vBoxLevel3; 
    
    
    private final Stage primaryStage; 
    private GameWorld gameWorld; 
    private LevelSettings manageLevel; 
    
    public LevelSelector(Stage primaryStage) throws IOException {
        super(new Group());
        
        this.primaryStage = primaryStage; 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/levelChoosing.fxml"));
        loader.setController(this);
        
        this.setRoot(loader.load());
        this.generateLevel(primaryStage);
    }
    
    
    public void generateLevel (Stage primaryStage){
        EventHandler chosenLevel = (EventHandler<MouseEvent>) (MouseEvent event) -> {
            if (vBoxLevel1.isPressed() == true) {
                manageLevel.setLevelNumber(1);
            }
            if (vBoxLevel2.isPressed() == true) {
                manageLevel.setLevelNumber(2);
            }
            if (vBoxLevel3.isPressed() == true) {
                manageLevel.setLevelNumber(3);
            }
        };
    }
    
    public void handleGameOver(){
        if (gameWorld.isVictory() == false) {
            try {
                Pane gameOver = new FXMLLoader(getClass().getResource("/fxml/gameOver.fxml")).load(); 
                gameWorld.getSceneNodes().getChildren().add(gameOver); 
                gameOver.setOnMouseClicked((event) -> {
                    try { 
                        Pane levelChoosing = new FXMLLoader(getClass().getResource("/fxml/levelChoosing.fxml")).load();
                    } catch (IOException ex) {
                        Logger.getLogger(LevelSelector.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                gameWorld.shutdown();
            });
            } catch (IOException e) {
            }
        }
        if (gameWorld.isVictory() == true) {
            try {
                Pane gameOver = new FXMLLoader(getClass().getResource("/fxml/victory.fxml")).load(); 
                gameWorld.getSceneNodes().getChildren().add(gameOver); 
                gameOver.setOnMouseClicked((event) -> {
                gameWorld.shutdown();
            });
            } catch (IOException e) {
            }
        }
    }
}
