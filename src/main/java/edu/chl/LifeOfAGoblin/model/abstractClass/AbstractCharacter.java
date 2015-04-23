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
    protected Node character = new Node();
    protected AbstractCharacter(String model, int health, int maxHealth) {
        character.attachChild(Resources.getInstance().getResources(model));
        character.setUserData("health", health);
        character.setUserData("maxHealth", maxHealth);
    }
    
    public Node getNode(){
        return character;
    }
}
