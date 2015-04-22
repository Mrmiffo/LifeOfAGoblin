/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.controller.PlayerListener;
import edu.chl.LifeOfAGoblin.utils.Resources;

/**
 *
 * @author Anton
 */
public class Level {
    Spatial scene;
    public Level(String levelName, PlayerListener pl){
        scene = Resources.getInstance().getResources(levelName);
//        Player player = new Player();
    }
}
