/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.test;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.TextureKey;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;
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
        //System setup
        if (System.getProperty("os.name").equals("Linux")) {
            isLinux = true;
        } 
        
        //Camera
//        this.flyCam.setEnabled(false);
        

        
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
        BulletAppState bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.getPhysicsSpace().add(landscape);
        bulletAppState.getPhysicsSpace().add(player.getControl(CharacterControl.class));
        
        //Character physics test:
        
        Material stone_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        TextureKey key2 = new TextureKey("Textures/Terrain/Rock/Rock.PNG");
//        key2.setGenerateMips(true);
//        Texture tex2 = assetManager.loadTexture(key2);
//        stone_mat.setTexture("ColorMap", tex2);
        Box box = new Box(1f,1f,1f);
        Geometry brick_geo = new Geometry("brick", box);
        brick_geo.setMaterial(stone_mat);

        /** Position the brick geometry  */
        brick_geo.setLocalTranslation(new Vector3f(0f, 10f, 0));
        /** Make brick physical with a mass > 0.0f. */
        RigidBodyControl brick_phy = new RigidBodyControl(2f);
        /** Add physical brick to physics space. */
        brick_geo.addControl(brick_phy);
        
        bulletAppState.getPhysicsSpace().add(brick_phy);
        rootNode.attachChild(brick_geo);
                
                
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
