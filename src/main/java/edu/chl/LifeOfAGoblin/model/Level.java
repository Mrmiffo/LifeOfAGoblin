/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.asset.plugins.FileLocator;
import edu.chl.LifeOfAGoblin.model.interfaces.IModeledNode;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
<<<<<<< HEAD
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import java.io.File;
=======
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
>>>>>>> spawnpoint

    
/**
 * The level model. Contains the model data of the level and the scene name.
 * @author Anton
 */
public class Level implements IModeledNode{
    private String scene;
    private Player player;
    
    /**
     * 
     * @param levelName the name of the level that should be created
     * @param player the player instance to load into the level.
     */
    public Level(String levelName, Player player){
        //Save the scene file to load.
        scene = levelName;
        this.player = player;
        Resources.getInstance().loadResource(scene, "scenes");
    }

    @Override
    public String getModelName() {
        return scene;
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.LEVEL;
    }
    
    public Player getPlayer(){
        return player;
    }

    void Spawn(int amount, AbstractNPC type) {
       //todo add functionality1 for spawning NPCs.
    }
}
