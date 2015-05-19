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
import edu.chl.LifeOfAGoblin.jME3.controller.NPCMoveControl;
import edu.chl.LifeOfAGoblin.jME3.controller.PhysicsTickControl;
import edu.chl.LifeOfAGoblin.jME3.controller.PlayerHealthControl;
import edu.chl.LifeOfAGoblin.jME3.controller.PlayerMoveControl;
import edu.chl.LifeOfAGoblin.jME3.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;

/**
 *
 * @author kakan
 */
class CharacterFactory {
    
    static void createPlayer(Node levelNode, Node node, Camera cam) {
        Node playerNode = createCharacter(new Player());
        ChaseCamera chaseCam = new ChaseCamera(cam);
        chaseCam.setRotationSensitivity(0);
        chaseCam.setDefaultHorizontalRotation(new Float(FastMath.PI/2));
        chaseCam.setDefaultVerticalRotation(new Float(FastMath.PI/9)); //20 degrees
        playerNode.addControl(chaseCam); //Adding a camera control to make the camera follow the player

        node.attachChild(playerNode);

        playerNode.setLocalTranslation(node.getWorldTranslation());
        levelNode.setLocalTranslation(0f, -5f, 0f);  
        PhysicsTickControl ptc = new PhysicsTickControl(playerNode);
        levelNode.addControl(ptc);
        PhysicsWrapper.getInstance().add(((PhysicsTickListener)ptc));
    }
    
    static Node createCharacter(AbstractCharacter nodeToCreate) {
        Node node = new Node();
        AbstractMoveControl amc;


        Spatial model = Resources.getInstance().getResources(nodeToCreate.getModelName());
        node.attachChild(model);
        node.addControl(new ModelControl(nodeToCreate));
        CapsuleCollisionShape shape;
        CharacterControl mover; //CharacterControl has been depricated prematurly due to BetterCharacterControl. Although BetterCharacterControl contains major flaws (such as missing step height) that make CharacterControl a better choice for this project.

        //Moving the model node slightly to fit the CollisionShape
        model.setLocalTranslation(new Vector3f(0, -nodeToCreate.getHeight(), 0));
        shape = new CapsuleCollisionShape(nodeToCreate.getWidth(), nodeToCreate.getHeight(), 1);
        mover = new CharacterControl(shape, 0.05f);

        GhostControl ghost = new GhostControl(shape);
        PhysicsWrapper.getInstance().add(mover);
        PhysicsWrapper.getInstance().add(ghost);
        mover.setJumpSpeed(nodeToCreate.getJumpStrength());

        if (nodeToCreate instanceof Player) {
            nodeToCreate = new Player();
            amc = new PlayerMoveControl();
            //A control which use the player model data to update the game hud health bar.
            node.addControl(new PlayerHealthControl());
            InputManagerWrapper.getInstance().registerListener((PlayerMoveControl) amc);
        } else {
            amc = new PlayerMoveControl();
        }

        //Attaching controls:
        node.addControl(mover);
        node.addControl(amc);
        node.addControl(ghost);

        //sets what to collide with
        if(nodeToCreate instanceof Player){
            ghost.setCollisionGroup(2);
        }else{
            ghost.setCollisionGroup(6);
            ghost.setCollideWithGroups(2);
        }
            return node;
        }
}
