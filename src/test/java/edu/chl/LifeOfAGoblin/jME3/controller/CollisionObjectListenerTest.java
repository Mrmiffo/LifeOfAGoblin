/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.bulletphysics.collision.narrowphase.ManifoldPoint;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
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
import static org.mockito.Mockito.*;

/**
 *
 * @author fredrik
 */
public class CollisionObjectListenerTest {
    Node node1 = new Node();
    
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
        Player testPlayer = mock(Player.class);
        ModelControl mc = new ModelControl(testPlayer);
        CapsuleCollisionShape shape = new CapsuleCollisionShape(1, 1, 1);
        GhostControl ghost = new GhostControl(shape);
        ghost.setCollisionGroup(2);
        node1.addControl(ghost);   
        node1.addControl(mc);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCollision() {
        // Setup test.
        Checkpoint testCheck = mock(Checkpoint.class);
        when(testCheck.getIsActivated()).thenReturn(false).thenReturn(true);
        SpawnPoint testSpawn = mock(SpawnPoint.class);
        when(testSpawn.getIsActivated()).thenReturn(false).thenReturn(true);
        FinalCheckpoint testFCheck = mock(FinalCheckpoint.class);
        when(testFCheck.getIsActivated()).thenReturn(false).thenReturn(true);
        Checkpoint testFaultyCheck = mock(Checkpoint.class);
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        
        node5.setUserData("nodeType", "CHECKPOINT");
        ModelControl mockcheckMc = new ModelControl(testCheck);
        BoxCollisionShape mockcheckBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl mockcheckGhost = new GhostControl(mockcheckBox);
        mockcheckGhost.setCollisionGroup(3);
        mockcheckGhost.setCollideWithGroups(2);
        node5.addControl(mockcheckMc);
        node5.addControl(mockcheckGhost);  
        
        node6.setUserData("nodeType", "SPAWNPOINT");
        ModelControl mockSpawnMc = new ModelControl(testSpawn);
        BoxCollisionShape mockSpawnBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl mockSpawnGhost = new GhostControl(mockSpawnBox);
        mockSpawnGhost.setCollisionGroup(4);
        mockSpawnGhost.setCollideWithGroups(2);
        node6.addControl(mockSpawnMc);
        node6.addControl(mockSpawnGhost);
        
        node7.setUserData("nodeType", "FINALCHECKPOINT");
        ModelControl mockFcheckMc = new ModelControl(testFCheck);
        BoxCollisionShape mockFcheckBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl mockFcheckGhost = new GhostControl(mockFcheckBox);
        mockFcheckGhost.setCollisionGroup(5);
        mockFcheckGhost.setCollideWithGroups(2);
        node7.addControl(mockFcheckMc);
        node7.addControl(mockFcheckGhost);
        
        ModelControl mockFaultycheckMc = new ModelControl(testFaultyCheck);
        BoxCollisionShape mockFaultycheckBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl mockFaultycheckGhost = new GhostControl(mockFaultycheckBox);
        mockFaultycheckGhost.setCollisionGroup(3);
        mockFaultycheckGhost.setCollideWithGroups(2);
        node8.addControl(mockFaultycheckMc);
        node8.addControl(mockFaultycheckGhost);
        
        CollisionObjectListener listener = new CollisionObjectListener();
        PhysicsCollisionEvent pce1 = new PhysicsCollisionEvent(1, node1.getControl(GhostControl.class), node5.getControl(GhostControl.class), new ManifoldPoint());
        PhysicsCollisionEvent pce2 = new PhysicsCollisionEvent(1, node1.getControl(GhostControl.class), node6.getControl(GhostControl.class), new ManifoldPoint());
        PhysicsCollisionEvent pce3 = new PhysicsCollisionEvent(1, node1.getControl(GhostControl.class), node7.getControl(GhostControl.class), new ManifoldPoint());
        PhysicsCollisionEvent pce4 = new PhysicsCollisionEvent(1, node1.getControl(GhostControl.class), node8.getControl(GhostControl.class), new ManifoldPoint());
        PhysicsCollisionEvent pce5 = new PhysicsCollisionEvent(1, node1.getControl(GhostControl.class), node1.getControl(GhostControl.class), new ManifoldPoint());

        // tests that AbstractCollisionObjects run collide after collisions, 
        // which means that they run setIsActivated.

        listener.collision(pce1);
        listener.collision(pce2);
        listener.collision(pce3);
        verify(testCheck, times(1)).collide();
        verify(testSpawn, times(1)).collide();
        verify(testFCheck, times(1)).collide();
        
        // tests that collide is not run in an activated AbstractCollisionObject
        
        when(testCheck.getIsActivated()).thenReturn(false).thenReturn(true);
        when(testSpawn.getIsActivated()).thenReturn(false).thenReturn(true);
        when(testFCheck.getIsActivated()).thenReturn(false).thenReturn(true);

        listener.collision(pce1);
        listener.collision(pce2);
        listener.collision(pce3);
        listener.collision(pce1);
        listener.collision(pce2);
        listener.collision(pce3);
        verify(testCheck, times(2)).collide();
        verify(testSpawn, times(2)).collide();
        verify(testFCheck, times(2)).collide();
        
        // tests that collision can handle objects with no userData
        
        listener.collision(pce4);
        verify(testFaultyCheck, times(0)).collide();
        
        // tests that collision can handle objects with wrong userData
        
        listener.collision(pce5);
        verify(((Player)node1.getControl(ModelControl.class).getModel()), times(0)).collide();
    }

    @Test
    public void testCollide() {
        // setup for test
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
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
        CollisionObjectListener listener = new CollisionObjectListener();
        Node node = new Node();
        BoxCollisionShape box = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl Ghost = new GhostControl(box);
        node.addControl(Ghost);
       
        // tests that collide does not return true if setCollideWithGroups
        // is missing
        assertFalse(listener.collide(node1.getControl(GhostControl.class), node.getControl(GhostControl.class)));
        assertFalse(listener.collide(node.getControl(GhostControl.class), node4.getControl(GhostControl.class)));
        Ghost.setCollisionGroup(6);
        Ghost.setCollideWithGroups(7);
       
        // tests that collide returns true when it should
        assertTrue(listener.collide(node1.getControl(GhostControl.class), node2.getControl(GhostControl.class)));
        assertTrue(listener.collide(node1.getControl(GhostControl.class), node3.getControl(GhostControl.class)));
        assertTrue(listener.collide(node1.getControl(GhostControl.class), node4.getControl(GhostControl.class)));
        
        // tests that collide does not return true if setCollideWithGroups 
        // is wrong
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