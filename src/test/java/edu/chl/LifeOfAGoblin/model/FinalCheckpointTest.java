/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.input.RawInputListener;
import com.jme3.input.TouchInput;
import com.jme3.system.JmeSystem;
import edu.chl.LifeOfAGoblin.model.NodeType;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.LifeOfAGoblin;
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
public class FinalCheckpointTest {
    private LifeOfAGoblin loag;
    AssetManager assetManager = null;
    AppStateManager stateManager = null;
    
    public FinalCheckpointTest() {
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
        this.assetManager = JmeSystem.newAssetManager(Thread.currentThread().getContextClassLoader().getResource("com/jme3/asset/Desktop.cfg"));
        this.stateManager = new AppStateManager(loag);
        StateManagerWrapper.getInstance().initialize(stateManager);
        Resources.getInstance().initialize(assetManager);
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
    
    }
   
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetNodeType() {
                // setup
        FinalCheckpoint cp1 = new FinalCheckpoint(1,1,1.0f);
        AbstractGameObject cp2 = new FinalCheckpoint(1,1,1.0f);
        Checkpoint cp3 = new FinalCheckpoint(1,1,1.0f);
        
        //tests that a checkpoints nodetype is checkpoint
        assertTrue(cp1.getNodeType().equals(NodeType.FINALCHECKPOINT));
        assertTrue(cp2.getNodeType().equals(NodeType.FINALCHECKPOINT));
        assertTrue(cp3.getNodeType().equals(NodeType.FINALCHECKPOINT));
    }

    @Test
    public void testCollide() {
        Profile testProfile = new Profile("testProfile");
        Profile.setActiveProfile(testProfile);
        Checkpoint cp1 = new FinalCheckpoint(1,1,1.0f);
        Checkpoint cp2 = new FinalCheckpoint(2,2,1.0f);
        
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
}