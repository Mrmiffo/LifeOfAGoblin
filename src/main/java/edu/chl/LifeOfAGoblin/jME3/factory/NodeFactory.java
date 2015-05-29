/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.audio.AudioNode;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.jME3.controller.CollisionListener;
import edu.chl.LifeOfAGoblin.model.ISpawnable;
import edu.chl.LifeOfAGoblin.model.character.AbstractCharacter;
import edu.chl.LifeOfAGoblin.model.character.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.gameObject.Level;
import edu.chl.LifeOfAGoblin.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.utils.Resources;
import edu.chl.LifeOfAGoblin.model.character.Boss;
import edu.chl.LifeOfAGoblin.model.character.Minion;
import edu.chl.LifeOfAGoblin.model.character.Player;
import java.util.List;

/**
 * A factory used to create a level node and fill existing nodes with data depending on the node type.
 * The factory will extract needed data from the model and add jME3 controls and data.
 * @author Anton
 */
public class NodeFactory {
    
    public static Node createNode(ISpawnable type){
        Node node = new Node();
        
        if (type instanceof AbstractCharacter) {
            if (type instanceof AbstractNPC) {
                if (type instanceof Minion) {
                    CharacterFactory.createCharacter(node, new Minion());
                } else if (type instanceof Boss) {
                    CharacterFactory.createCharacter(node, new Boss());
                } 
            } else if (type instanceof Player) {
                CharacterFactory.createPlayer(node, null);
            }
        }
        return node;
    }
    
    /**
     * Creates a Node represeting a level, gives it everything it needs based
     * on the provided levelObject's children and attaches camera, controls
     * and physics.
     * @param levelToCreate the Level object containing all the level's children
     * @param cam the camera to be attached to the level.
     * @return the finished levelNode.
     */
    public static Node createModeledLevelNode(Level levelToCreate, Camera cam){
        Node levelNode = ((Node)Resources.getInstance().getResources(levelToCreate.getModelName()));
        List<Spatial> nodeList = levelNode.getChildren();
                System.out.println(nodeList.size());
        for(Spatial s: nodeList){
            LevelNodeBuilder.identifyNode(levelNode, (Node)s, cam);
        }
        
        //Creating a CollisionShape that matches the terrain of the level.
        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(levelNode);
        
        //Makes the shape solid.
        RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
        PhysicsWrapper.getInstance().add(landscape);
        levelNode.addControl(landscape);
        
        //----------------------------MOVE------------------------------
        //Allows object collision.
        CollisionListener listener = new CollisionListener();
        PhysicsWrapper.getInstance().addCollisionListener(listener);
        //--------------------------------------------------------------
        
        //Add the sound to the level
        AudioNode gameMusic = (AudioNode) Resources.getInstance().getResources("magical_theme.wav");
        gameMusic.setPositional(false);
        gameMusic.setLooping(true);
        gameMusic.setVolume(10);
        gameMusic.play();
        levelNode.attachChild(gameMusic);
        
        return levelNode;
    }
}
