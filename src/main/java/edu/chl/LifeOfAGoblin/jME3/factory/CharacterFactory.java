/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.bullet.PhysicsTickListener;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.input.ChaseCamera;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.jME3.controller.AbstractMoveControl;
import edu.chl.LifeOfAGoblin.jME3.controller.ModelControl;
import edu.chl.LifeOfAGoblin.jME3.controller.PhysicsTickControl;
import edu.chl.LifeOfAGoblin.jME3.controller.PlayerHealthControl;
import edu.chl.LifeOfAGoblin.jME3.controller.PlayerMoveControl;
import static edu.chl.LifeOfAGoblin.jME3.factory.CharacterFactory.createCharacter;
import edu.chl.LifeOfAGoblin.jME3.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;
import edu.chl.LifeOfAGoblin.model.interfaces.IModeledNode;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;

/**
 *
 * @author kakan
 */
class CharacterFactory {
    
    static void createPlayer(Node levelNode, Node node, Camera cam) {
        
        //Creates the basic Player
        Node playerNode = createCharacter(new Player());
        
        playerNode.setLocalTranslation(node.getWorldTranslation());
        levelNode.setLocalTranslation(0f, -5f, 0f);
        
        //Attach the player to the level
        node.attachChild(playerNode);
        
        //A control which use the player model data to update the game hud health bar.
        playerNode.addControl(new PlayerHealthControl());

        attachCamera(playerNode, cam);
        attachPhyscisTickControl(levelNode, playerNode);
        
    }
    
    
    static Node createCharacter(AbstractCharacter nodeToCreate) {
        //Creates the node which will represent the character
        Node node = new Node();
        
        //Connects the model to the node
        node.addControl(new ModelControl(nodeToCreate));
        
        makeSolid(node);
        makeMoveable(node);
        giveGraphicalRepresentation(node);
        
        return node;
    }
    
    private static void makeSolid(Node node) {
        CapsuleCollisionShape shape = createShape(node);
        attachCharacterControl(node, shape);
        attachGhostControl(node, shape);
        
    }    
    //Give the character a shape
    private static CapsuleCollisionShape createShape(Node node) {
        INode model = node.getControl(ModelControl.class).getModel();
        return new CapsuleCollisionShape(model.getWidth(), model.getHeight(), 1);
    }
    
    private static void attachCharacterControl(Node node, CapsuleCollisionShape shape) {
        AbstractCharacter character = (AbstractCharacter)node.getControl(ModelControl.class).getModel();
        //NOTE: CharacterControl has been depricated prematurly due to BetterCharacterControl. Although BetterCharacterControl contains major flaws (such as missing step height) that make CharacterControl a better choice for this project.
        CharacterControl mover = new CharacterControl(shape, 0.05f);
        mover.setJumpSpeed(character.getJumpStrength());
        PhysicsWrapper.getInstance().add(mover);
        node.addControl(mover);
    }
    
    private static void attachGhostControl(Node node, CapsuleCollisionShape shape) {
        //Could we use another abstraction? ICollidable? AbstractGameObject?
        AbstractCharacter model = (AbstractCharacter)node.getControl(ModelControl.class).getModel();
        
        GhostControl ghost = new GhostControl(shape);
        PhysicsWrapper.getInstance().add(ghost);
        ghost.setCollisionGroup(model.getCollisionGroup());
        
        //TODO add more special cases
        if (!(model instanceof Player)) {
            //sets what to collide with
            ghost.setCollideWithGroups(2);
        }
        
        //Attaching ghost control
        node.addControl(ghost);
    }
    
    private static void makeMoveable(Node node) {
        AbstractCharacter model = (AbstractCharacter)node.getControl(ModelControl.class).getModel();
        AbstractMoveControl amc = model.getAbstractMoveControl();
        if (model instanceof Player) {
            InputManagerWrapper.getInstance().registerListener((PlayerMoveControl) amc);
        }
        node.addControl(amc);
    }
    
    //Attachs the graphical representation
    private static void giveGraphicalRepresentation(Node node) {
        IModeledNode model = (IModeledNode)node.getControl(ModelControl.class).getModel();
        Spatial appearance = Resources.getInstance().getResources(model.getModelName());
        node.attachChild(appearance);
        //Moving the appearnace slightly to fit the CollisionShape
        appearance.setLocalTranslation(new Vector3f(0, -model.getHeight(), 0));
    }
    
    //Attaches a camera to the player
    private static void attachCamera(Node playerNode, Camera cam) {
        ChaseCamera chaseCam = new ChaseCamera(cam);
        chaseCam.setRotationSensitivity(0);
        chaseCam.setDefaultHorizontalRotation(new Float(FastMath.PI/2));
        chaseCam.setDefaultVerticalRotation(new Float(FastMath.PI/9)); //20 degrees
        playerNode.addControl(chaseCam); //Adding a camera control to make the camera follow the player
    }

    private static void attachPhyscisTickControl(Node levelNode, Node playerNode) {
        PhysicsTickControl ptc = new PhysicsTickControl(playerNode);
        levelNode.addControl(ptc);
        PhysicsWrapper.getInstance().add(((PhysicsTickListener)ptc));
    }
}
