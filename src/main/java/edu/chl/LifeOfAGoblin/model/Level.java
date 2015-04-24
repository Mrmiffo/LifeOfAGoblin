/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.light.AmbientLight;
import com.jme3.light.Light;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.controller.PlayerMoveControl;
import edu.chl.LifeOfAGoblin.utils.Resources;

/**
 *
 * @author Anton
 */
public class Level {
    private Spatial scene;
    
    /**
     * 
     * @param levelName the name of the level that should be created
     */
    
    public Level(String levelName){
        //Player creation
        //TODO The player class will fetch its MoveControl from input manager, thus making this code viable
//        Node player = createPlayer();
        
        //Getting the scene
        scene = loadScene(levelName);
        
        //Makes the scene solid
        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(scene);
        RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
        scene.addControl(landscape);
        
        //Creates a light for the scene
        Light light = createLight();
        
        //TODO Should probaly be created and saved somewhere else (GameAppState/physics manager)
        BulletAppState bulletAppState = new BulletAppState();
//        stateManager.attach(bulletAppState);
        
        //TODO Replace this with physics manager call
        bulletAppState.getPhysicsSpace().add(landscape);
//        bulletAppState.getPhysicsSpace().add(player.getControl(CharacterControl.class));
               
        //Attach light an player to scene 
        scene.addLight(light);
//        scene.attachChild(player);
    }
    
    //TODO Remove this constructor when all needed help classes have benn implemented
    public Level(String levelName, PlayerMoveControl pmc, PhysicsSpace ps) {
        //Player creation
        Node player = new Player(100, 100, pmc).getNode();
        
        //Getting the scene
        scene = loadScene(levelName);
        
        
        //Makes the scene solid
        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(scene);
        RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
        scene.addControl(landscape);
        
        //TODO Make into sunlight (DirectionalLight?)
        //Adds light too the scene
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(3f));
        
        //TODO Should probaly be created and saved somewhere else (GameAppState/physics manager)
        BulletAppState bulletAppState = new BulletAppState();
//        stateManager.attach(bulletAppState);
        
        //TODO Replace this with physics manager call
        bulletAppState.getPhysicsSpace().add(landscape);
//        bulletAppState.getPhysicsSpace().add(player.getControl(CharacterControl.class));
               
        //Attach light an player to scene 
        scene.addLight(al);
//        scene.attachChild(player);
    }
    
    //TODO Uncomment this method when player fetches its own MoveControl
    /*
    private Node createPlayer() {
        Player p = new Player(100, 100);
        return p.getNode();
    }*/
    
    //TODO Change return type to DirectionalLight?
    /**
     * Creates a light source with a white colour.
     * 
     * @return light the light source
     */
    private Light createLight() {
        //TODO Make into sunlight (DirectionalLight?)
        //Creates a light for the scene
        AmbientLight l = new AmbientLight();
        l.setColor(ColorRGBA.White.mult(3f));
        return l;
    }
    
    private RigidBodyControl createRigidBody() {
        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(scene);
        RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
        return landscape;
    }
    
    /**
     * Loads the wanted scene from the game's assets
     * 
     * @param name the name of the wanted scene
     * @return the scene
     */
    private Spatial loadScene(String name) {
        Spatial s = Resources.getInstance().getResources(name);
        //TODO Does the translation need to be set by hand?
        s.setLocalTranslation(0f, -5f, 0f);
        return s;
    }
    
    /**
     * Adds all the wanted content of the scene
     */
    private void setupScene() {
        //Adds a light source to the scene
        Light light = createLight();
        scene.addLight(light);
        
        RigidBodyControl landscape = createRigidBody();
        scene.addControl(landscape);
        
        //TODO add proper physics manager call
        //PhysicsManager.getInstance().addToPhysicsSpace(landscape); //Or something
    }
    
    public Spatial getScene(){
        return scene;
    }
}
