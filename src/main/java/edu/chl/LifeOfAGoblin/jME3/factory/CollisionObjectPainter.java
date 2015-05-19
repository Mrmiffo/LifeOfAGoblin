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
import edu.chl.LifeOfAGoblin.model.interfaces.INode;

/**
 * A class responsible for "painting" nodes giving them models and adding
 * controls
 * @author fredrik
 */

class CollisionObjectPainter {
    /**
     * Paints a node of the type collisionObject
     * @param typeToCreate the specific type of collisionobject to create
     * @param userDataNode the node to be painted. It also contains all 
     * relevant userdata.
     */
    
    static void paintCollisionObject(INode model, Node userDataNode) {
        ModelControl modelControl = new ModelControl(model);
        Vector3f halfExtent = new Vector3f(model.getWidth(),model.getHeight(), 0);
        BoxCollisionShape checkBox = new BoxCollisionShape(halfExtent);
        GhostControl ghostControl = new GhostControl(checkBox);
        ghostControl.setCollisionGroup(3); //FIX
        ghostControl.setCollideWithGroups(2); //FIX
        PhysicsWrapper.getInstance().add(ghostControl);
        userDataNode.addControl(modelControl);
        userDataNode.addControl(ghostControl);
        if (model instanceof SpawnPoint) {
            userDataNode.addControl((Control)((SpawnPoint)model).getSpawnControl());
        }
    }
}
