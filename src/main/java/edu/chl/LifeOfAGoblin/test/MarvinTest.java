/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.test;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.controller.PlayerMoveControl;
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.utils.Resources;

/**
 * This class is for testing purposes only. It will recreate parts of the application in order to test new functionality.
 * @author Anton
 */
public class MarvinTest extends SimpleApplication{
    //Test character player hierarchy
    
    private boolean isLinux;
    
    public static void main(String[] args){
        MarvinTest app = new MarvinTest();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        
        if (System.getProperty("os.name").equals("Linux")) {
            isLinux = true;
        }        
        this.flyCam.setEnabled(false);
        BulletAppState bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        
        System.out.println("Loading resources...");
        loadModels();
        loadScenes();
        loadSounds();
        viewPort.setBackgroundColor(ColorRGBA.Blue);
        
        //Setup keys
        System.out.println("Setting up keys...");
        PlayerMoveControl playerListener = new PlayerMoveControl();
        initKeys(playerListener);
        
//      Player creation test
        System.out.println("Starting player creation test...");
        Player testPlayer = new Player(100, 100, playerListener);
        Node player = testPlayer.getNode();
        if (player == null){
            System.out.println("No node loaded");
        } else {
            System.out.println("Testmodel sucessfully loaded");
        }

        System.out.println("Player creation test finished");
        
        System.out.println("Loading terrain...");
        Spatial scene = Resources.getInstance().getResources("TestScene");
        scene.setLocalTranslation(0f, -5f, 0f);
        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(scene);
        RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
        scene.addControl(landscape);

        
        
        System.out.println("Setting up light...");
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(3f));

        System.out.println("Adding physics...");
        bulletAppState.getPhysicsSpace().add(landscape);
        bulletAppState.getPhysicsSpace().add(player.getControl(CharacterControl.class));
        
        System.out.println("Attaching to rootNode..");
        rootNode.addLight(al);
        rootNode.attachChild(player);
        rootNode.attachChild(scene);

//        Level currLevel = new Level("Level1", playerListener);
//        rootNode.attachChild(currLevel);
    }
    
    
    private void loadModels() {

        System.out.println("Loading models...");
        if (isLinux) {
            assetManager.registerLocator("src/main/java/edu/chl/LifeOfAGoblin/assets/models", FileLocator.class);
            Resources.getInstance().addResource("Goblin", assetManager.loadModel("Goblin2.j3o"));
        } else {
            assetManager.registerLocator("src\\main\\java\\edu\\chl\\LifeOfAGoblin\\assets\\models", FileLocator.class);
            Resources.getInstance().addResource("Goblin", assetManager.loadModel("Goblin2.j3o"));
        }
    }

    private void loadScenes() {
        System.out.println("Loading scenes...");
        if (isLinux) {
            assetManager.registerLocator("src/main/java/edu/chl/LifeOfAGoblin/assets/scenes", FileLocator.class);
        } else {
            assetManager.registerLocator("src\\main\\java\\edu\\chl\\LifeOfAGoblin\\assets\\scenes", FileLocator.class);
        }
        Resources.getInstance().addResource("TestScene", assetManager.loadModel("testScene.j3o"));
    }

    private void loadSounds() {
        System.out.println("Loading sounds...");
        if (isLinux) {
            assetManager.registerLocator("src/main/java/edu/chl/LifeOfAGoblin/assets/sounds", FileLocator.class);
        } else {
            assetManager.registerLocator("src\\main\\java\\edu\\chl\\LifeOfAGoblin\\assets\\sounds", FileLocator.class);
        }
    }

    private void initKeys(PlayerMoveControl playerListener) {
        inputManager.addMapping("walkRight", new KeyTrigger(keyInput.KEY_D));
        inputManager.addMapping("walkLeft", new KeyTrigger(keyInput.KEY_A));
        inputManager.addMapping("jump", new KeyTrigger(keyInput.KEY_W), new KeyTrigger(keyInput.KEY_SPACE));
        inputManager.addListener(playerListener, "walkRight", "walkLeft", "jump");
    }
    
}
