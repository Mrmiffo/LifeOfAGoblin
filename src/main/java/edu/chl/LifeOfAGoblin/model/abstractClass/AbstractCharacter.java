/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.utils.Resources;

/**
 *
 * @author Anton
 */
public abstract class AbstractCharacter {
    protected Node character;
    protected AbstractCharacter(String model, int health, int maxHealth) {
        character = (Node) Resources.getInstance().getResources(model);
        character.setUserData("health", health);
        character.setUserData("maxHealth", maxHealth);
    }
    
    public Node getNode(){
        return character;
    }
}
