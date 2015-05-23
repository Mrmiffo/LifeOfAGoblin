/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.input.*;
import com.jme3.input.awt.AwtKeyInput;
import com.jme3.input.awt.AwtMouseInput;
import com.jme3.input.lwjgl.JInputJoyInput;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.jME3.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractGameObject;
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
public class CheckpointTest {
    
    public CheckpointTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        /**
         * You need a TouchInput to create an Inputmanager and the only class in 
         * jme3 that implements TouchInput cannot be imported, and that is 
         * the reason this exists 
         */

        class TestTouchInput implements TouchInput{

            @Override
            public void setSimulateMouse(boolean bln) {
            }

            @Override
            public boolean getSimulateMouse() {
                return true;
            }

            @Override
            public boolean isSimulateMouse() {
            return true;
            }

            @Override
            public void setSimulateKeyboard(boolean bln) {
            }

            @Override
            public void setOmitHistoricEvents(boolean bln) {
            }

            @Override
            public void initialize() {
            }

            @Override
            public void update() {
            }

            @Override
            public void destroy() {
            }

            @Override
            public boolean isInitialized() {
                return true;
            }

            @Override
            public void setInputListener(RawInputListener rl) {
            }

            @Override
            public long getInputTimeNanos() {
                return 1;
            }
            
        }
    InputManagerWrapper.getInstance().initialize(new InputManager(new AwtMouseInput(), new AwtKeyInput(), new JInputJoyInput(), new TestTouchInput()));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetNodeType() {
        // setup
        Checkpoint cp1 = new Checkpoint(1,1,1.0f);
        AbstractGameObject cp2 = new Checkpoint(1,1,1.0f);
        Checkpoint cp3 = new FinalCheckpoint(1,1,1.0f);
        
        //tests that a checkpoint's nodetype is checkpoint
        assertTrue(cp1.getNodeType().equals(NodeType.CHECKPOINT));
        assertTrue(cp2.getNodeType().equals(NodeType.CHECKPOINT));
        assertFalse(cp3.getNodeType().equals(NodeType.CHECKPOINT));

    }

    @Test
    public void testCollide() {
        //setup 
        Profile testProfile = new Profile("testProfile");
        Profile.setActiveProfile(testProfile);
        Checkpoint cp1 = new Checkpoint(1,1,1.0f);
        Checkpoint cp2 = new Checkpoint(2,2,1.0f);
        
        // tests that collide is not run on an activated checkpoint
        cp1.collide(new Player());
        cp2.activate();
        cp2.collide(new Player());
        assertTrue(Profile.getActiveProfile().getProgress().getLastVisitedCheckpoint()==1);
        assertTrue(Profile.getActiveProfile().getProgress().getLastVisitedLevel()==1);
        
        // Tests that collide is not run on collisions with something that 
        // is not a player.
       cp2.collide(new Checkpoint(3,3,1.0f));
       assertTrue(Profile.getActiveProfile().getProgress().getLastVisitedCheckpoint()==1);
       assertTrue(Profile.getActiveProfile().getProgress().getLastVisitedLevel()==1);
       
       // tests that a checkpoint is activated after a collision
       cp1.inactivate();
       cp1.collide(new Checkpoint(3,3,1.0f));
       assertFalse(cp1.isActivated());
       cp1.collide(new Player());
       assertTrue(cp1.isActivated());
       
       
       
    }

    @Test
    public void testActivate() {
        // setup
        Checkpoint cp1 = new Checkpoint(1,1,1.0f);
        
        //tests that the checkpoint is activated correctly
        assertFalse(cp1.isActivated());
        cp1.activate();
        assertTrue(cp1.isActivated());
        cp1.activate();
        assertTrue(cp1.isActivated());
    }

    @Test
    public void testInactivate() {
        // setup
        Checkpoint cp1 = new Checkpoint(1,1,1.0f);
        
        //tests that the checkpoint is deactivated correctly
        cp1.activate();
        assertTrue(cp1.isActivated());
        cp1.inactivate();
        assertFalse(cp1.isActivated());
        cp1.inactivate();
        assertFalse(cp1.isActivated());
    }

}