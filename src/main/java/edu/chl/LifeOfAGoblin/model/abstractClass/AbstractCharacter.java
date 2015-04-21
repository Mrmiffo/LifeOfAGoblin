/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.utils.Resources;

/**
 *
 * @author Anton
 */
public abstract class AbstractCharacter {
    protected Node character;
    public AbstractCharacter(String model) {
        character = (Node)Resources.getInstance().getResources(model);
    }
    
    public Node getNode(){
        return character;
    }
}
