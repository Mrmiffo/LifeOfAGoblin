/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.utils;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.control.UpdateControl;
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
        Node node1 = new Node();
        Node node2 = new Node();
        Node lvl = new Node();
        
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

    }
    
    @After
    public void tearDown() {
        for(Object obj: ((BulletAppState)StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class)).getPhysicsSpace().getGhostObjectList()){
            PhysicsWrapper.getInstance().remove(obj);
        }

        for(Object obj: ((BulletAppState)StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class)).getPhysicsSpace().getCharacterList()){
            PhysicsWrapper.getInstance().remove(obj);
        }
        for(Object obj: ((BulletAppState)StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class)).getPhysicsSpace().getRigidBodyList()){
            PhysicsWrapper.getInstance().remove(obj);
        }        
     }

    @Test
    public void testGetInstance() {
    }

    @Test
    
    public void testAdd_Control() {
        //setup 

        BoxCollisionShape shape = new BoxCollisionShape(new Vector3f(1,1,1));
        GhostControl ghostControl = new GhostControl(shape);
        RigidBodyControl rigidBodyControl = new RigidBodyControl(shape);
        CharacterControl characterControl = new CharacterControl(shape, 1.0f);
        UpdateControl updateControl = new UpdateControl();
        
        //tests that a Ghostcontrol is added
        PhysicsWrapper.getInstance().add(ghostControl);
        assertTrue(((BulletAppState)StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class)).getPhysicsSpace().getGhostObjectList().contains(ghostControl));
        
        //tests that a Rigidbodycontrol can be added
        PhysicsWrapper.getInstance().add(rigidBodyControl);
        assertTrue(((BulletAppState)StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class)).getPhysicsSpace().getRigidBodyList().contains(rigidBodyControl));
        
        //tests that a CharacterControl is added
        PhysicsWrapper.getInstance().add(characterControl);
        assertTrue(((BulletAppState)StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class)).getPhysicsSpace().getCharacterList().contains(characterControl));
        
        //tests that an incomplete control is not added, exception will be 
        //thrown if test fails
        GhostControl faultyControl = new GhostControl();
        PhysicsWrapper.getInstance().add(faultyControl);
        assertFalse(((BulletAppState)StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class)).getPhysicsSpace().getGhostObjectList().contains(faultyControl));
        
        //tests that a non PhysicsControl can't be added, exception will be 
        //thrown if test fails
        PhysicsWrapper.getInstance().add(updateControl);
        
        //tests that the same control cannot be added twice
        PhysicsWrapper.getInstance().add(ghostControl);
        assertTrue(((BulletAppState)StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class)).getPhysicsSpace().getGhostObjectList().size() == 1);
        
    }


    @Test
    public void testRemove() {
        //setup
        GhostControl control = new GhostControl(new BoxCollisionShape(new Vector3f(1,1,1)));
        
        //tests that the object actually is removed
        PhysicsWrapper.getInstance().add(control);
        PhysicsWrapper.getInstance().remove(control);
        assertTrue(((BulletAppState)StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class)).getPhysicsSpace().getGhostObjectList().isEmpty());
        
        // tests that it can handle non PhysicsObect, should not throw exception. 
       PhysicsWrapper.getInstance().remove(12);
    
        // tests that it can handle removing objects that don't exist in the 
        //physicsspace, should not throw exception.
        PhysicsWrapper.getInstance().remove(control);
    }

} 