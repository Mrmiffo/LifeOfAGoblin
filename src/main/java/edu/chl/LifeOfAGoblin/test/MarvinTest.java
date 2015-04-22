/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.test;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.controller.PlayerListener;
import edu.chl.LifeOfAGoblin.model.Level;
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.utils.Resources;

/**
 * This class is for testing purposes only. It will recreate parts of the application in order to test new functionality.
 * @author Anton
 */
public class MarvinTest extends SimpleApplication{
    //Test character player hierarchy
    public static void main(String[] args){
        MarvinTest app = new MarvinTest();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        System.out.println("Loading resources...");
        loadModels();
        loadScenes();
        loadSounds();
        
                
        PlayerListener playerListener = new PlayerListener();
        inputManager.addMapping("walkRight", new KeyTrigger(keyInput.KEY_D));
        inputManager.addMapping("walkLeft", new KeyTrigger(keyInput.KEY_A));
        inputManager.addMapping("jump", new KeyTrigger(keyInput.KEY_W), new KeyTrigger(keyInput.KEY_SPACE));
        inputManager.addListener(playerListener, "walkRight", "walkLeft", "jump");
        
//      Player creation test
        System.out.println("Starting player creation test...");
        Player testPlayer = new Player(100, 100, playerListener);
        Node node = testPlayer.getNode();
        if (node == null){
            System.out.println("No node loaded");
        } else {
            System.out.println("Testmodel sucessfully loaded");
        }
        rootNode.attachChild(node);
        System.out.println("Player creation test finished");

//        Level currLevel = new Level("Level1", playerListener);
//        rootNode.attachChild(currLevel);
    }
    
    
    private void loadModels() {
        System.out.println("Loading models...");
        assetManager.registerLocator("src\\main\\java\\edu\\chl\\LifeOfAGoblin\\assets\\models", FileLocator.class);
        Resources.getInstance().addResource("Goblin", assetManager.loadModel("Goblin.j3o"));
    }

    private void loadScenes() {
        System.out.println("Loading scenes...");
        assetManager.registerLocator("src\\main\\java\\edu\\chl\\LifeOfAGoblin\\assets\\scenes", FileLocator.class);
        
    }

    private void loadSounds() {
        System.out.println("Loading sounds...");
        assetManager.registerLocator("src\\main\\java\\edu\\chl\\LifeOfAGoblin\\assets\\sounds", FileLocator.class);
        
    }
    
}
