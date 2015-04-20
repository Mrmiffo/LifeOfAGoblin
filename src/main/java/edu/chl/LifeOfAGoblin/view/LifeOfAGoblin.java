/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.view;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
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
        ClassLoader classLoader = getClass().getClassLoader();
        assetManager.registerLocator("src\\main\\java\\edu\\chl\\LifeOfAGoblin\\assets\\models", FileLocator.class);
        Resources.getInstance().addResource("Goblin", assetManager.loadModel("Goblin.j3o"));
    }

    private void loadScenes() {
        ClassLoader classLoader = getClass().getClassLoader();
        assetManager.registerLocator("src\\main\\java\\edu\\chl\\LifeOfAGoblin\\assets\\scenes", FileLocator.class);
        
    }

    private void loadSounds() {
        ClassLoader classLoader = getClass().getClassLoader();
        assetManager.registerLocator("src\\main\\java\\edu\\chl\\LifeOfAGoblin\\assets\\sounds", FileLocator.class);
        
    }
    
}
