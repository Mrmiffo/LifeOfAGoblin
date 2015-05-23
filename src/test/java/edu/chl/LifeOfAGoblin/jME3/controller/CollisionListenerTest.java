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
import edu.chl.LifeOfAGoblin.model.Checkpoint;
import edu.chl.LifeOfAGoblin.model.FinalCheckpoint;
import edu.chl.LifeOfAGoblin.model.Minion;
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.model.SpawnPoint;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 *
 * @author fredrik
 */
public class CollisionListenerTest {
    Node node1 = new Node();
    
    public CollisionListenerTest() {
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
        SpawnPoint testSpawn = mock(SpawnPoint.class);
        FinalCheckpoint testFCheck = mock(FinalCheckpoint.class);
        Checkpoint testFaultyCheck = mock(Checkpoint.class);
        Minion testMinion = mock(Minion.class);
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node9 = new Node();
        Node node10 = new Node();
        
        node5.setUserData("nodeType", "CHECKPOINT");
        ModelControl mockcheckMc = new ModelControl(testCheck);
        BoxCollisionShape mockcheckBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl mockcheckGhost = new GhostControl(mockcheckBox);
        node5.addControl(mockcheckMc);
        node5.addControl(mockcheckGhost);  
        
        node6.setUserData("nodeType", "SPAWNPOINT");
        ModelControl mockSpawnMc = new ModelControl(testSpawn);
        BoxCollisionShape mockSpawnBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl mockSpawnGhost = new GhostControl(mockSpawnBox);
        node6.addControl(mockSpawnMc);
        node6.addControl(mockSpawnGhost);
        
        node7.setUserData("nodeType", "FINALCHECKPOINT");
        ModelControl mockFcheckMc = new ModelControl(testFCheck);
        BoxCollisionShape mockFcheckBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl mockFcheckGhost = new GhostControl(mockFcheckBox);
        node7.addControl(mockFcheckMc);
        node7.addControl(mockFcheckGhost);
        
        ModelControl mockFaultycheckMc = new ModelControl(testFaultyCheck);
        BoxCollisionShape mockFaultycheckBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl mockFaultycheckGhost = new GhostControl(mockFaultycheckBox);
        node8.addControl(mockFaultycheckMc);
        node8.addControl(mockFaultycheckGhost);
        
        node9.setUserData("NodeType", "CHECKPOINT");
        BoxCollisionShape mockFaultyobjectBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl mockFaultyObjectGhost = new GhostControl(mockFaultyobjectBox);
        node9.addControl(mockFaultyObjectGhost);
        
        
        node10.setUserData("NodeType", "MINION");
        ModelControl mockMinionMc = new ModelControl(testMinion);
        BoxCollisionShape mockMinionBox = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl mockMinionGhost = new GhostControl(mockMinionBox);
        node10.addControl(mockMinionMc);
        node10.addControl(mockMinionGhost);        
        
        CollisionListener listener = new CollisionListener();
        PhysicsCollisionEvent pce1 = new PhysicsCollisionEvent(1, node1.getControl(GhostControl.class), node5.getControl(GhostControl.class), new ManifoldPoint());
        PhysicsCollisionEvent pce2 = new PhysicsCollisionEvent(1, node1.getControl(GhostControl.class), node6.getControl(GhostControl.class), new ManifoldPoint());
        PhysicsCollisionEvent pce3 = new PhysicsCollisionEvent(1, node1.getControl(GhostControl.class), node7.getControl(GhostControl.class), new ManifoldPoint());
        PhysicsCollisionEvent pce4 = new PhysicsCollisionEvent(1, node1.getControl(GhostControl.class), node8.getControl(GhostControl.class), new ManifoldPoint());
        PhysicsCollisionEvent pce6 = new PhysicsCollisionEvent(1, node5.getControl(GhostControl.class), node1.getControl(GhostControl.class), new ManifoldPoint());
        PhysicsCollisionEvent pce7 = new PhysicsCollisionEvent(1, node1.getControl(GhostControl.class), node9.getControl(GhostControl.class), new ManifoldPoint());
        PhysicsCollisionEvent pce8 = new PhysicsCollisionEvent(1, node1.getControl(GhostControl.class), node10.getControl(GhostControl.class), new ManifoldPoint());

        // tests that AbstractCollisionObjects run collide after collisions, 

        listener.collision(pce1);
        listener.collision(pce2);
        listener.collision(pce3);
        verify(testCheck, times(1)).collide(((ICollidable)node1.getControl(ModelControl.class).getModel()));
        verify(testSpawn, times(1)).collide(((ICollidable)node1.getControl(ModelControl.class).getModel()));
        verify(testFCheck, times(1)).collide(((ICollidable)node1.getControl(ModelControl.class).getModel()));
        
     
        
        // tests that collision can handle objects with no userData
        
        listener.collision(pce4);
        verify(testFaultyCheck, times(0)).collide(((ICollidable)node1.getControl(ModelControl.class).getModel()));
        
        
        //tests collisions with indata in the other order.

        listener.collision(pce6);
        verify(testCheck, times(2)).collide(((ICollidable)node1.getControl(ModelControl.class).getModel()));
        verify(((Player)node1.getControl(ModelControl.class).getModel()), times(2)).collide(((ICollidable)node5.getControl(ModelControl.class).getModel()));
        
        //tests that collision can handle objects with no model
        listener.collision(pce7);
        verify(((Player)node1.getControl(ModelControl.class).getModel()), times(0)).collide(testMinion);
    
        //tests that players can collide with NPCs
        listener.collision(pce8);
        verify(((Player)node1.getControl(ModelControl.class).getModel()), times(1)).collide(((ICollidable)node10.getControl(ModelControl.class).getModel()));
        verify(testMinion, times(1)).collide(((ICollidable)node1.getControl(ModelControl.class).getModel()));

        
    }      

}