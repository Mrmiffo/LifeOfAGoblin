/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.jME3.controller.FinalCheckpointControl;
import edu.chl.LifeOfAGoblin.jME3.controller.ModelControl;
import edu.chl.LifeOfAGoblin.jME3.controller.SpawnControl;
import edu.chl.LifeOfAGoblin.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.model.gameObject.SpawnPoint;
import edu.chl.LifeOfAGoblin.model.ICollidable;

/**
 * A class responsible for "painting" nodes giving them models and adding
 * controls
 *
 * @author fredrik
 */
class CollisionObjectPainter {

    /**
     * Paints a node of the type collisionObject
     *
     * @param typeToCreate the specific type of collisionobject to create
     * @param node the node to be painted. It also contains all relevant
     * userdata.
     */
    static void paintCollisionObject(ICollidable collisionObject, Node node) {
        ModelControl modelControl = new ModelControl(collisionObject);
        Vector3f halfExtent = new Vector3f(collisionObject.getCollisionWidth(), collisionObject.getCollisionHeight(), 0);
        BoxCollisionShape checkBox = new BoxCollisionShape(halfExtent);
        GhostControl ghostControl = new GhostControl(checkBox);
        
        PhysicsWrapper.getInstance().addControl(ghostControl);
        
        node.addControl(modelControl);
        node.addControl(ghostControl);

        if (collisionObject instanceof SpawnPoint) {
            SpawnControl sc = new SpawnControl();
            node.addControl(sc);
            sc.initialize();
        }
        
        if (node.getUserData("nodeType").equals("FINALCHECKPOINT")) {
            FinalCheckpointControl sc = new FinalCheckpointControl();
            node.addControl(sc);
            sc.initialize();
        }
    }
}
