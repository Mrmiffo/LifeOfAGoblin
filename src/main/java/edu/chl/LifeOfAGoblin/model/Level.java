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
    private Node scene;
    
    /**
     * Creates and stores a scene with a specified name and adds all wanted objects to the scene.
     * 
     * @param levelName the name of the level that should be created
     */
    
    public Level(String levelName){
        //Getting the scene
        scene = loadScene(levelName);
        
         //Creates a player node and adds it to the scene
        //TODO The player class will fetch its MoveControl from input manager, thus making this code viable
//        Node player = createPlayer();
//        scene.attachChild(player);
        
        //Adds a light source to the scene
        Light light = createLight();
        scene.addLight(light);
        
        //Adds a solid landscape
        RigidBodyControl landscape = createRigidBody();
        scene.addControl(landscape);
        //TODO add proper physics manager call
        //PhysicsManager.getInstance().addToPhysicsSpace(landscape); //Or something
        
        //TODO Populate scene with NPCs, interactable objects, all the stuff that's not added in SceneComposer
    }
    
    //TODO Remove this constructor when all needed help classes have benn implemented
    public Level(String levelName, PlayerMoveControl pmc, PhysicsSpace ps) {
        //Player creation
//        Node player = new Player(100, 100, pmc).getNode();
        
        //Getting the scene
        scene = loadScene(levelName);
        
        //Adds a light source to the scene
        Light light = createLight();
        scene.addLight(light);
        
        //Adds a solid landscape
        RigidBodyControl landscape = createRigidBody();
        scene.addControl(landscape);
        
        //TODO Should probaly be created and saved somewhere else (GameAppState/physics manager)
        ps.add(landscape);
//        ps.add(player.getControl(CharacterControl.class));
    }
    
    //TODO Uncomment this method when player fetches its own MoveControl
    /*
    private Node createPlayer() {
        Player p = new Player(100, 100);
        
        //TODO Change to physics manager call. Move to Player class?
        bulletAppState.getPhysicsSpace().add(p.getNode().getControl(CharacterControl.class)); 
        
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
    
    /**
     * Creates a solid body with the same shape as the scene
     * @return 
     */
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
    private Node loadScene(String name) {
        Node s = (Node)Resources.getInstance().getResources(name);
        //TODO Does the translation need to be set by hand?
        s.setLocalTranslation(0f, -5f, 0f);
        return s;
    }
    
    public Spatial getScene(){
        return scene;
    }
}
