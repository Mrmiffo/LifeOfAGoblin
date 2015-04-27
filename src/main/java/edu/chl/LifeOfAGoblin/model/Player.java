/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;



import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import edu.chl.LifeOfAGoblin.controller.PlayerAttackControl;
import edu.chl.LifeOfAGoblin.controller.PlayerMoveControl;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;
import edu.chl.LifeOfAGoblin.utils.NodeFactory;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Anton
 */
public class Player extends AbstractCharacter {

    
    public Player(int health, int maxHealth){
        super("Goblin", health, maxHealth);

    }

    @Override
    public Map<String, Object> getNodeData() {
        Map<String, Object> nodeData = super.getNodeData();
        //TODO Add custom player data here.
        return nodeData;
    }

    @Override
    public NodeFactory.NodeType getNodeType() {
        return NodeFactory.NodeType.PLAYER;
    }
            
}
