/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.control.Control;
import edu.chl.LifeOfAGoblin.jME3.controller.ModelControl;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.model.SpawnPoint;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;

/**
 * A class responsible for "painting" nodes giving them models and adding
 * controls
 * @author fredrik
 */

class CollisionObjectPainter {
    /**
     * Paints a node of the type collisionObject
     * @param typeToCreate the specific type of collisionobject to create
     * @param node the node to be painted. It also contains all 
     * relevant userdata.
     */
    
    static void paintCollisionObject(ICollidable collisionObject, Node node) {
        ModelControl modelControl = new ModelControl(collisionObject);
        Vector3f halfExtent = new Vector3f(collisionObject.getCollisionWidth(), collisionObject.getCollisionHeight(), 0);
        BoxCollisionShape checkBox = new BoxCollisionShape(halfExtent);
        GhostControl ghostControl = new GhostControl(checkBox);
        
        ghostControl.setCollisionGroup(3); //FIX
        ghostControl.setCollideWithGroups(2); //FIX
        
        PhysicsWrapper.getInstance().add(ghostControl);
        
        node.addControl(modelControl);
        node.addControl(ghostControl);
        
        if (collisionObject instanceof SpawnPoint) {
            node.addControl((Control)((SpawnPoint)collisionObject).getSpawnControl());
        }
    }
}
