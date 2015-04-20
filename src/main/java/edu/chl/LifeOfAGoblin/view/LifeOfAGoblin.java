/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.view;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.utils.Resources;


/**
 *
 * @author Anton
 */
public class LifeOfAGoblin extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        loadResources();
    }

    private void loadResources() {
        loadModels();
        loadScenes();
        loadSounds();
        

    }

    private void loadModels() {
        System.out.println("Loading models...");
        ClassLoader classLoader = getClass().getClassLoader();
        assetManager.registerLocator("src\\main\\java\\edu\\chl\\LifeOfAGoblin\\assets\\models", FileLocator.class);
        Resources.getInstance().addResource("Goblin", assetManager.loadModel("Goblin.j3o"));
    }

    private void loadScenes() {
        System.out.println("Loading scenes...");
        ClassLoader classLoader = getClass().getClassLoader();
        assetManager.registerLocator("src\\main\\java\\edu\\chl\\LifeOfAGoblin\\assets\\scenes", FileLocator.class);
        
    }

    private void loadSounds() {
        System.out.println("Loading sounds...");
        ClassLoader classLoader = getClass().getClassLoader();
        assetManager.registerLocator("src\\main\\java\\edu\\chl\\LifeOfAGoblin\\assets\\sounds", FileLocator.class);
        
    }
    
}
