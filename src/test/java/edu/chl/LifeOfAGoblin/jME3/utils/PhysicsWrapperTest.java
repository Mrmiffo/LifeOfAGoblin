/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.utils;

import com.jme3.app.state.AppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.jME3.view.LifeOfAGoblin;
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
public class PhysicsWrapperTest {
        private Node testCharacter;
        private LifeOfAGoblin loag;
        AppStateManager stateManager = null;
    
    public PhysicsWrapperTest() {


    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         this.loag = new LifeOfAGoblin();
         this.stateManager = new AppStateManager(loag);
         StateManagerWrapper.getInstance().initialize(stateManager);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetInstance() {
    }

    @Test
    public void testAdd_Control() {
        //setup 
        this.testCharacter = new Node();
        BoxCollisionShape shape = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl control = new GhostControl(shape);
        testCharacter.addControl(control);
        loag.getRootNode().attachChild(testCharacter);
        
        //tests that a control is added
        PhysicsWrapper.getInstance().add(control);
        //assertTrue(PhysicsWrapper.getInstance().getBulletAppstate().getPhysicsSpace().getGhostObjectList().contains(control));
        
        //tests that an incomplete control is not added
        GhostControl faultyControl = new GhostControl();
        PhysicsWrapper.getInstance().add(faultyControl);
       // assertFalse(PhysicsWrapper.getInstance().getBulletAppstate().getPhysicsSpace().getGhostObjectList().contains(faultyControl));
        
    }

    @Test
    public void testAddCollisionListener() {
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void testAdd_PhysicsTickListener() {
    }
}