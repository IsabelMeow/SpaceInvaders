package edu.vanier.ufo.ui;

import edu.vanier.ufo.helpers.ResourcesManager;
import edu.vanier.ufo.engine.*;
import edu.vanier.ufo.game.*;
import javafx.event.EventHandler;
import javafx.scene.CacheHint;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;
import javafx.scene.image.ImageView;

/**
 * This is a simple game world simulating a bunch of spheres looking like atomic
 * particles colliding with each other. When the game loop begins the user will
 * notice random spheres (atomic particles) floating and colliding. The user
 * will navigate his/her ship by right clicking the mouse to thrust forward and
 * left click to fire weapon to atoms.
 *
 * @author cdea
 */
public class GameWorld extends GameEngine {

    LevelSettings gameLevel;
    public Label levelNumber; 
    Ship spaceShip; 
    
    
    public GameWorld(int fps, String title) {
        super(fps, title);
    }

    /**
     * Initialize the game world by adding sprite objects.
     *
     * @param primaryStage The game window or primary stage.
     */
    @Override
    public void initialize(final Stage primaryStage) {
        this.gameLevel = new LevelSettings(1, 12); 
        this.levelNumber = new Label();
        // Sets the window title
        primaryStage.setTitle(getWindowTitle());
        //primaryStage.setFullScreen(true);

        // Create the scene
        setSceneNodes(new Group());
        setGameSurface(new Scene(getSceneNodes(), 1000, 600));

        // Change the background of the main scene.
        getGameSurface().setFill(Color.BLACK);

        primaryStage.setScene(getGameSurface());

        // Setup Game input
        setupInput(primaryStage);

        // Create many spheres
        generateManySpheres(5);

        getSpriteManager().addSprites(this.gameLevel.getShip());
        getSceneNodes().getChildren().add(0, this.gameLevel.getShip().getNode());
        // mouse point
        VBox stats = new VBox();

        HBox row1 = new HBox();
        gameLevel.setLevelNumber(1);
        this.levelNumber.setText("Level: " + gameLevel.getLevelNumber());
        this.levelNumber.setTextFill(Color.WHITE);
        row1.getChildren().add(levelNumber);
        stats.getChildren().add(row1);
        
       
        //TODO: Add the HUD here.
        getSceneNodes().getChildren().add(0, stats);


        // load sound files
        getSoundManager().loadSoundEffects("laser", getClass().getClassLoader().getResource(ResourcesManager.SOUND_LASER));
    }

    /**
     * Sets up the mouse input.
     *
     * @param primaryStage The primary stage (app window).
     */
    
    private void setupInput(Stage primaryStage) {
        System.out.println("Ship's center is (" + this.gameLevel.getShip().getCenterX() + ", " + this.gameLevel.getShip().getCenterY() + ")");
        
        
        EventHandler fireOrMove = (EventHandler<KeyEvent>) (KeyEvent event) -> {
            if (KeyCode.SPACE == event.getCode()) {
                this.gameLevel.getShip().shieldToggle();
                return;
            }
            this.gameLevel.getShip().changeWeapon(event.getCode());
     
            if (KeyCode.DIGIT1 == event.getCode()) {
            Missile missile = spaceShip.fire();
                getSpriteManager().addSprites(missile);
        } else if (KeyCode.DIGIT2 == event.getCode()){
            Missile missile = new Missile(ResourcesManager.missile2); 
           
        } else if (KeyCode.DIGIT3 == event.getCode()){
            Missile missile = new Missile (ResourcesManager.missile3); 
             
        }

            if (KeyCode.L == event.getCode()) {
               
                Missile missile = (new Missile(ResourcesManager.missile1)); 
                this.gameLevel.getShip().setFireMissile(missile); 
                this.gameLevel.getShip().fire(); 
                System.out.println("Created missile");
                getSceneNodes().getChildren().add(0, missile.getNode()); 
               
                 getSoundManager().playSound("laser");
            }
             if (KeyCode.P == event.getCode()) {
               
                Missile missile = (new Missile(ResourcesManager.missile2)); 
                this.gameLevel.getShip().setFireMissile(missile); 
                this.gameLevel.getShip().fire(); 
                System.out.println("Created missile");
                getSceneNodes().getChildren().add(0, missile.getNode()); 
               
                 getSoundManager().playSound("laser");
            }
              if (KeyCode.O == event.getCode()) {
               
                Missile missile = (new Missile(ResourcesManager.missile3)); 
                this.gameLevel.getShip().setFireMissile(missile); 
                this.gameLevel.getShip().fire(); 
                System.out.println("Created missile");
                getSceneNodes().getChildren().add(0, missile.getNode()); 
               
                 getSoundManager().playSound("laser");
            }
        
        };
        primaryStage.getScene().setOnKeyPressed(fireOrMove);

        EventHandler fireOrMove1 = (EventHandler<MouseEvent>) (MouseEvent event) -> {
            //mousePressPtLabel.setText("Mouse Press PT = (" + event.getX() + ", " + event.getY() + ")");
            if (event.getButton() == MouseButton.PRIMARY) {

                // Aim
                this.gameLevel.getShip().plotCourse(event.getX(), event.getY(), false);

                //fire
                Missile missile = this.gameLevel.getShip().fire();
               getSpriteManager().addSprites(missile);

                // play sound
                //getSoundManager().playSound("laser");

                //getSceneNodes().getChildren().add(0, missile.getNode());

            } else if (event.getButton() == MouseButton.SECONDARY) {
                // determine when all atoms are not on the game surface. Ship should be one sprite left.

                // stop ship from moving forward
                this.gameLevel.getShip().applyTheBrakes(event.getX(), event.getY());
                // move forward and rotate ship
                this.gameLevel.getShip().plotCourse(event.getX(), event.getY(), true);
            }
        };

        // Initialize input
        primaryStage.getScene().setOnMousePressed(fireOrMove1);

    
        
    }

    /**
     * Make some more space spheres (Atomic particles)
     *
     * @param numSpheres The number of random sized, color, and velocity atoms
     * to generate.
     */
    private void generateManySpheres(int numSpheres) {
        Random rnd = new Random();
        Scene gameSurface = getGameSurface();
        for (int i = 0; i < numSpheres; i++) {
            //Randomly selects sprites from getInvadersSprites between the # of elements in the Hashmap
            Random randomElement = new Random();
            Atom atom = new Atom(ResourcesManager.getInvaderSprites().get(1 + randomElement.nextInt(ResourcesManager.getInvaderSprites().size())));           
            ImageView atomImage = atom.getImageViewNode();
            // random 0 to 2 + (.0 to 1) * random (1 or -1)
            // Randomize the location of each newly generated atom.
            atom.setVelocityX((rnd.nextInt(2) + rnd.nextDouble()) * (rnd.nextBoolean() ? 1 : -1));
            atom.setVelocityY((rnd.nextInt(2) + rnd.nextDouble()) * (rnd.nextBoolean() ? 1 : -1));

            // random x between 0 to width of scene
            double newX = rnd.nextInt((int) gameSurface.getWidth() - 100);

            if (newX > (gameSurface.getWidth() - (rnd.nextInt(15) + 5 * 2))) {
                newX = gameSurface.getWidth() - (rnd.nextInt(15) + 5 * 2);
            }

            double newY = rnd.nextInt((int) (gameSurface.getHeight() - 300));
            if (newY > (gameSurface.getHeight() - (rnd.nextInt(15) + 5 * 2))) {
                newY = gameSurface.getHeight() - (rnd.nextInt(15) + 5 * 2);
            }

            atomImage.setTranslateX(newX);
            atomImage.setTranslateY(newY);
            atomImage.setVisible(true);
            atomImage.setId("invader");
            atomImage.setCache(true);
            atomImage.setCacheHint(CacheHint.SPEED);
            atomImage.setManaged(false);

            // add to actors in play (sprite objects)
            getSpriteManager().addSprites(atom);

            // add sprite's 
            getSceneNodes().getChildren().add(atom.getNode());
        }
    }

    /**
     * Each sprite will update it's velocity and bounce off wall borders.
     *
     * @param sprite - An atomic particle (a sphere).
     */
    @Override
    protected void handleUpdate(Sprite sprite) {
        // advance object
        sprite.update();
        if (sprite instanceof Missile) {
            removeMissiles((Missile) sprite);
        } else {
            bounceOffWalls(sprite);
        }
    }

    /**
     * Change the direction of the moving object when it encounters the walls.
     *
     * @param sprite The sprite to update based on the wall boundaries. TODO The
     * ship has got issues.
     */
    private void bounceOffWalls(Sprite sprite) {
        // bounce off the walls when outside of boundaries

        Node displayNode;
        if (sprite instanceof Ship) {
            displayNode = sprite.getNode();//((Ship)sprite).getCurrentShipImage();
        } else {
            displayNode = sprite.getNode();
        }
        // Get the group node's X and Y but use the ImageView to obtain the width.
        if (sprite.getNode().getTranslateX() > (getGameSurface().getWidth() - displayNode.getBoundsInParent().getWidth())
                || displayNode.getTranslateX() < 0) {

            // bounce the opposite direction
            sprite.setVelocityX(sprite.getVelocityX() * -1);
        }
        // Get the group node's X and Y but use the ImageView to obtain the height.
        if (sprite.getNode().getTranslateY() > getGameSurface().getHeight() - displayNode.getBoundsInParent().getHeight()
                || sprite.getNode().getTranslateY() < 0) {
            sprite.setVelocityY(sprite.getVelocityY() * -1);
        }
    }

    /**
     * Remove missiles when they reach the wall boundaries.
     *
     * @param missile The missile to remove based on the wall boundaries.
     */
    private void removeMissiles(Missile missile) {
        // bounce off the walls when outside of boundaries
        if (missile.getNode().getTranslateX() > (getGameSurface().getWidth()
                - missile.getNode().getBoundsInParent().getWidth())
                || missile.getNode().getTranslateX() < 0) {

            getSpriteManager().addSpritesToBeRemoved(missile);
            getSceneNodes().getChildren().remove(missile.getNode());

        }
        if (missile.getNode().getTranslateY() > getGameSurface().getHeight()
                - missile.getNode().getBoundsInParent().getHeight()
                || missile.getNode().getTranslateY() < 0) {

            getSpriteManager().addSpritesToBeRemoved(missile);
            getSceneNodes().getChildren().remove(missile.getNode());
        }
    }

    /**
     * How to handle the collision of two sprite objects. Stops the particle by
     * zeroing out the velocity if a collision occurred. /** How to handle the
     * collision of two sprite objects. Stops the particle by
     *
     *
     * @param spriteA Sprite from the first list.
     * @param spriteB Sprite from the second list.
     * @return boolean returns a true if the two sprites have collided otherwise
     * false.
     */
    @Override
    protected boolean handleCollision(Sprite spriteA, Sprite spriteB) {
        //TODO: implement collision detection here.

        return false;
    }
}
