/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.model.Checkpoint;
import edu.chl.LifeOfAGoblin.model.FinalCheckpoint;
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.model.SpawnPoint;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fredrik
 */
public class CollisionObjectListenerTest {
    Node node1 = new Node();
    Node node2 = new Node();
    Node node3 = new Node();
    Node node4 = new Node();
    
    public CollisionObjectListenerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {  
        node1.setUserData("nodeType", "PLAYER");
        CapsuleCollisionShape shape = new CapsuleCollisionShape(1, 1, 1);
        GhostControl ghost = new GhostControl(shape);
        ghost.setCollisionGroup(2);
        node1.addControl(ghost);
        node2.setUserData("nodeType", "CHECKPOINT");
        Checkpoint cp = new Checkpoint(1, 1, 1f);
        ModelControl checkMc = new ModelControl(cp);
        BoxCollisionShape checkBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl checkGhost = new GhostControl(checkBox);
        checkGhost.setCollisionGroup(3);
        checkGhost.setCollideWithGroups(2);
        node2.addControl(checkMc);
        node2.addControl(checkGhost);
        node3.setUserData("nodeType", "SPAWNPOINT");
        SpawnPoint sp = new SpawnPoint(new SpawnControl(),1, NodeType.MINION, 1f);
        ModelControl spawnMc = new ModelControl(sp);
        BoxCollisionShape spawnBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl spawnGhost = new GhostControl(spawnBox);
        spawnGhost.setCollisionGroup(4);
        spawnGhost.setCollideWithGroups(2);
        node3.addControl(spawnMc);
        node3.addControl(spawnGhost);
        node4.setUserData("nodeType", "FINALCHECKPOINT");
        FinalCheckpoint fcp = new FinalCheckpoint(1, 1, 1f);
        ModelControl fCheckMc = new ModelControl(fcp);
        BoxCollisionShape fcheckBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl fcheckGhost = new GhostControl(fcheckBox);
        fcheckGhost.setCollisionGroup(5);
        fcheckGhost.setCollideWithGroups(2);
        node4.addControl(fCheckMc);
        node4.addControl(fcheckGhost);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCollision() {
    }

    @Test
    public void testCollide() {
        CollisionObjectListener listener = new CollisionObjectListener();
        Node node = new Node();
        BoxCollisionShape box = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl Ghost = new GhostControl(box);
        node.addControl(Ghost);
        assertFalse(listener.collide(node1.getControl(GhostControl.class), node.getControl(GhostControl.class)));
        assertFalse(listener.collide(node.getControl(GhostControl.class), node4.getControl(GhostControl.class)));
        Ghost.setCollisionGroup(6);
        Ghost.setCollideWithGroups(7);        
        assertTrue(listener.collide(node1.getControl(GhostControl.class), node2.getControl(GhostControl.class)));
        assertTrue(listener.collide(node1.getControl(GhostControl.class), node3.getControl(GhostControl.class)));
        assertTrue(listener.collide(node1.getControl(GhostControl.class), node4.getControl(GhostControl.class)));
        assertFalse(listener.collide(node2.getControl(GhostControl.class), node3.getControl(GhostControl.class)));
        assertFalse(listener.collide(node2.getControl(GhostControl.class), node4.getControl(GhostControl.class)));
        assertFalse(listener.collide(node1.getControl(GhostControl.class), node.getControl(GhostControl.class)));
        assertFalse(listener.collide(node.getControl(GhostControl.class), node4.getControl(GhostControl.class)));
    }

    @Test
    public void testControlUpdate() {
    }

    @Test
    public void testControlRender() {
    }
}