package edu.vanier.ufo.helpers;

import java.util.HashMap;

/**
 * A resource manager providing useful resource definitions used in this game.
 *
 * @author Sleiman
 */
public class ResourcesManager {

    /**
     * Used to control the speed of the game.
     */
    public static final int FRAMES_PER_SECOND = 85;
    private static final String RESOURCES_FOLDER = "";
    private static final String IMAGES_FOLDER = RESOURCES_FOLDER + "images/";
    private static final String SOUNDS_FOLDER = RESOURCES_FOLDER + "sounds/";
     public static final String MISSILE_FOLDER = RESOURCES_FOLDER + "missiles/"; 
    // Ship images.
    public static final String SPACE_SHIP = IMAGES_FOLDER + "spiked ship.png";
    public static final String SPACE_STAR_SHIP = IMAGES_FOLDER + "starship.png";
    public static final String SPACE_TANK = IMAGES_FOLDER + "tank.png";
    // Rocket images
    public static final String ROCKET_SMALL = IMAGES_FOLDER + "rocket.png";
    public static final String ROCKET_FIRE = IMAGES_FOLDER + "missile.png";

    // Invader sprites.
    public static final String INVADER_LARGE_SHIP = IMAGES_FOLDER + "large_invader_b.png";
    public static final String INVADER_SMALL_SHIP = IMAGES_FOLDER + "small_invader_b.png";
    public static final String INVADER_UFO = IMAGES_FOLDER + "ufo.png";
    public static final String INVADER_CHICKEN = IMAGES_FOLDER + "rounded-chicken.png";
    public static final String INVADER_BEE = IMAGES_FOLDER + "small-bee.png";
    public static final String INVADER_SCI_FI = IMAGES_FOLDER + "sci-fi.png";

    public static final String ENEMY_FOLDER = RESOURCES_FOLDER + "invaders/";
    public static final String Inv1 = ENEMY_FOLDER + "spaceAstronauts_002.png";
    public static final String Inv2 = ENEMY_FOLDER + "spaceAstronauts_008.png";
    public static final String Inv3 = ENEMY_FOLDER + "spaceAstronauts_014.png"; 
    public static final String Inv4 = ENEMY_FOLDER + "spaceAstronauts_016.png"; 
    public static final String Inv5 = ENEMY_FOLDER + "spaceBuilding_001.png"; 
    public static final String Inv6 = ENEMY_FOLDER + "spaceBuilding_013.png"; 
    public static final String Inv7 = ENEMY_FOLDER + "spaceBuilding_015.png"; 
    public static final String Inv8 = ENEMY_FOLDER + "spaceMeteors_001.png"; 
    public static final String Inv9 = ENEMY_FOLDER + "spaceBuilding_011.png"; 
    public static final String Inv10 = ENEMY_FOLDER + "spaceShips_009.png"; 
    public static final String Inv11 = ENEMY_FOLDER + "shipBeige_manned.png"; 
    public static final String Inv12 = ENEMY_FOLDER + "shipBlue_manned.png"; 
    public static final String Inv13 = ENEMY_FOLDER + "shipGreen_manned.png"; 
    public static final String Inv14 = ENEMY_FOLDER + "shipPink_manned.png"; 
    public static final String Inv15 = ENEMY_FOLDER + "shipYellow_manned.png"; 
    public static final String explosion = ENEMY_FOLDER + "explosion.gif"; 
            //keep
            // Sound effect files
   
    public static final String missile1 = MISSILE_FOLDER + "spaceMissiles_001.png"; 
    public static final String missile2 = MISSILE_FOLDER + "spaceMissiles_003.png"; 
    public static final String missile3 = MISSILE_FOLDER + "spaceMissiles_035.png"; 
    
  
    public static final String SOUND_LASER = SOUNDS_FOLDER + "pew pew.mp4";
    //public static final String SOUND_LASER = SOUNDS_FOLDER + "alienMove2.wav";    

    public static final String[] INADER_SPRITES_PATH = {
        INVADER_UFO, INVADER_CHICKEN, INVADER_BEE, INVADER_SCI_FI
    };

    public static final String SPACESHIP_FOLDER = RESOURCES_FOLDER + "SpaceShip/";
    public static final String SS1 = SPACESHIP_FOLDER + "spaceShips_001.png";
    public static final String SS2 = SPACESHIP_FOLDER + "spaceShips_002.png";
    public static final String SS3 = SPACESHIP_FOLDER + "spaceShips_003.png";
    public static final String SS4 = SPACESHIP_FOLDER + "spaceShips_004.png";
    

//    public static final String ROCKET_SMALL = IMAGES_FOLDER + "rocket.png";
    public static HashMap<Integer, String> getInvaderSprites() {
        HashMap<Integer, String> invaders = new HashMap<Integer, String>();
        invaders.put(1, Inv1);
        invaders.put(2, Inv2);
        invaders.put(3, Inv3);
        invaders.put(4, Inv4);
        invaders.put(5, Inv5);
        invaders.put(6, Inv6);
        invaders.put(7, Inv7);
        invaders.put(8, Inv8);
        invaders.put(9, Inv9);
        invaders.put(10, Inv10);
        invaders.put(6, Inv11);
        invaders.put(7, Inv12);
        invaders.put(8, Inv13);
        invaders.put(9, Inv14);
        invaders.put(10, Inv15);
        return invaders;
    }

}
