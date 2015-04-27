/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.model.interfaces.IModeledNode;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;
import edu.chl.LifeOfAGoblin.utils.Resources;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Anton
 */
public abstract class AbstractCharacter implements INode, IModeledNode{
    Integer health;
    Integer maxHealth;
    String model;
    protected AbstractCharacter(String model, int health, int maxHealth) {
        this.model = model;
        this.health = health;
        this.maxHealth = maxHealth;
    }
    
    public Map<String, Object> getNodeData(){
        Map<String, Object> nodeData = new HashMap<>();
        nodeData.put("health", health);
        nodeData.put("maxHealth", maxHealth);
        return nodeData;
    }
    
    public String getModel(){
        return model;
    }
}
