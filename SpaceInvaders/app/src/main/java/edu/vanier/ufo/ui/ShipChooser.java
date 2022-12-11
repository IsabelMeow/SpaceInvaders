/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vanier.ufo.ui;

import edu.vanier.ufo.game.Ship;
import edu.vanier.ufo.helpers.ResourcesManager;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class ShipChooser {

    private Ship ship;
    private ArrayList<String> Ships;

    public ArrayList<String> shipList(ArrayList<String> Ships) {
        Ships.add(ResourcesManager.SS1);
        Ships.add(ResourcesManager.SS2);
        Ships.add(ResourcesManager.SS3);
        Ships.add(ResourcesManager.SS4);        
        return Ships;
    }
    
    public void initialize(){
    
    
    
    }

}
