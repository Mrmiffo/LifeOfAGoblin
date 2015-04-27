/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.controller.PlayerAttackControl;
import edu.chl.LifeOfAGoblin.controller.PlayerMoveControl;
import edu.chl.LifeOfAGoblin.model.interfaces.IModeledNode;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;
import java.util.Set;

/**
 *
 * @author Anton
 */
public class NodeFactory {
    public enum NodeType{
        PLAYER,
        LEVEL,
        NPC
    }
    
    public NodeFactory(){
        
    }
    
    public static Node createModeledNode(IModeledNode nodeToCreate){
        Node node = new Node();
        node.attachChild(Resources.getInstance().getResources(nodeToCreate.getModel()));
        //Setting object data:
        Set<String> tempSet = nodeToCreate.getNodeData().keySet();
        for (String key: tempSet){
            node.setUserData(key, nodeToCreate.getNodeData().get(key));
        }
        
        switch (nodeToCreate.getNodeType()){
            case PLAYER:
                float collisionShapeHeight = 1f;
                float collisionShapeWidth = 0.5f;
                //Moving the model node slightly to fit the CollisionShape
                node.getChild(0).setLocalTranslation(new Vector3f(0,-collisionShapeHeight,0));
                //Setting upp collision shape and character control:
                CapsuleCollisionShape shape = new CapsuleCollisionShape(collisionShapeWidth, collisionShapeHeight, 1);
                //CharacterControl has been depricated prematurly due to BetterCharacterControl. Although BetterCharacterControl contains major flaws (such as missing step height) that make CharacterControl a better choice for this project.
                CharacterControl mover = new CharacterControl(shape, 0.05f);
                //Set the character jumpspeed. 12 is just right for this character to jump 1f.
                mover.setJumpSpeed(12);
                //Setting up PlayerMoveControl which translates keycommands to node actions.
                PlayerMoveControl pmc = new PlayerMoveControl();
                //TODO register PlayerMoveControl to the KeyManager
                
                //Attaching controls:
                node.addControl(mover);
                node.addControl(pmc);
                
                
        }
            
        
        return node;
    }
}
