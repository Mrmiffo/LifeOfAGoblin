/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;

/**
 *
 * @author Anton
 */
public class Player extends AbstractCharacter {
    private float modelShapeHeight = 1f;
    private float modelShapeWidth = 0.5f;
    
    public Player(int health, int maxHealth){
        super("Goblin2.j3o", health, maxHealth);

    }

    @Override
    public NodeType getNodeType() {
        return NodeType.PLAYER;
    }
    
    public float getModelShapeHeight(){
        return modelShapeHeight;
    }
    
    public float getModelShapeWidth(){
        return modelShapeWidth;
    }

    @Override
    public void killCharacter() {
        //TODO Kill the character somehow.
    }
    

            
}
