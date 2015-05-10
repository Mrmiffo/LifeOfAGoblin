/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;
import edu.chl.LifeOfAGoblin.factory.NodeFactory;
import edu.chl.LifeOfAGoblin.factory.NodeType;
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
    public NodeType getNodeType() {
        return NodeType.PLAYER;
    }
            
}
