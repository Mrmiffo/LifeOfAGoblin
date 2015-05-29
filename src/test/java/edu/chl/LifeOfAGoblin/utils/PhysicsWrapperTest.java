/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.objects.PhysicsCharacter;
import com.jme3.bullet.objects.PhysicsGhostObject;
import com.jme3.bullet.objects.PhysicsRigidBody;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.control.UpdateControl;
import com.jme3.system.JmeSystem;
import edu.chl.LifeOfAGoblin.jME3.game.LifeOfAGoblin;
import java.util.Collection;
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
     
     }

    @Test
    public void testGetInstance() {
    }

    @Test
    
    public void testAdd_Control() {

        //tests that method can handle null input
        PhysicsWrapper.getInstance().add((GhostControl)null);
    }


    @Test
    public void testRemove() {

        //tests that method can handle null input
        PhysicsWrapper.getInstance().remove(null);
    }

} 