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
import edu.chl.LifeOfAGoblin.jME3.controller.FinalCheckpointControl;
import edu.chl.LifeOfAGoblin.jME3.controller.ModelControl;
import edu.chl.LifeOfAGoblin.jME3.controller.SpawnControl;
import edu.chl.LifeOfAGoblin.model.character.Minion;
import edu.chl.LifeOfAGoblin.model.gameObject.FinalCheckpoint;
import edu.chl.LifeOfAGoblin.model.gameObject.IActivatable;
import edu.chl.LifeOfAGoblin.model.gameObject.SpawnPoint;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ulrika
 */
public class CollisionObjectPainterTest {
    private FinalCheckpoint fcp;
    private SpawnPoint sp;
    private Node node1;
    private Node node2;
    private Minion minion;
    
    public CollisionObjectPainterTest() {
    }
    
    @Before
    public void setUp() {
        fcp = new FinalCheckpoint(1,1,1);
        sp = new SpawnPoint(1, minion, 1);
        node1 = new Node();
        node2 = new Node();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPaintCollisionObject() {
        //setup
        CollisionObjectPainter.paintCollisionObject(sp, node1);
        CollisionObjectPainter.paintCollisionObject(fcp, node2);
        Control c1;
        Control c2;
        
        //tests that ghostcontrols are added
        try {
            //setup
            c1 = node1.getControl(GhostControl.class);
            c2 = node2.getControl(GhostControl.class);  
            Vector3f measurements1 = ((BoxCollisionShape)((GhostControl)c1).getCollisionShape()).getHalfExtents();
            Vector3f measurements2 = ((BoxCollisionShape)((GhostControl)c2).getCollisionShape()).getHalfExtents();
            //tests that ghostcontrols have a correct shape
            assertTrue(measurements1.x == sp.getCollisionWidth());
            assertTrue(measurements1.y == sp.getCollisionHeight());
            assertTrue(measurements1.z == 0); 
            assertTrue(measurements2.x == fcp.getCollisionWidth());
            assertTrue(measurements2.y == fcp.getCollisionHeight());
            assertTrue(measurements2.z == 0);         
        } catch (NullPointerException ex) {
            fail();
        }
                
        //tests that modelcontrols are added correctly 
        try {
            //setup
            c1 = node1.getControl(ModelControl.class);
            c2 = node2.getControl(ModelControl.class);
            IActivatable object1 = ((IActivatable)((ModelControl)c1).getModel());
            IActivatable object2 = ((IActivatable)((ModelControl)c2).getModel());
            
            //tests that modelcontrols have the right model
            assertTrue(object1.equals(sp));
            assertTrue(object2.equals(fcp));
        } 
        catch (NullPointerException ex) {
            fail();
        }
        
        //tests that spawncontrols are added to spawnpoints
        try{
            //setup
            node1.getControl(SpawnControl.class).setEnabled(true);
        }
        catch (NullPointerException ex) {
            fail();
        }
        
        //tests that FinalCheckpointControls are added to FinalCheckpoints
        try{
            //setup
            node2.getControl(FinalCheckpointControl.class).setEnabled(true);
        }
        catch (NullPointerException ex) {
            fail();
        }
    }
    
}