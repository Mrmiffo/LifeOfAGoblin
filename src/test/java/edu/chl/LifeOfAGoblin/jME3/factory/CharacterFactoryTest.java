/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.input.InputManager;
import com.jme3.input.RawInputListener;
import com.jme3.input.TouchInput;
import com.jme3.input.awt.AwtKeyInput;
import com.jme3.input.awt.AwtMouseInput;
import com.jme3.input.lwjgl.JInputJoyInput;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.control.Control;
import edu.chl.LifeOfAGoblin.jME3.controller.ModelControl;
import edu.chl.LifeOfAGoblin.jME3.controller.character.NPCCollisionControl;
import edu.chl.LifeOfAGoblin.jME3.controller.character.NPCMoveControl;
import edu.chl.LifeOfAGoblin.jME3.controller.character.PlayerHealthControl;
import edu.chl.LifeOfAGoblin.jME3.controller.character.PlayerMoveControl;
import edu.chl.LifeOfAGoblin.model.character.AbstractCharacter;
import edu.chl.LifeOfAGoblin.model.character.Minion;
import edu.chl.LifeOfAGoblin.model.character.Player;
import edu.chl.LifeOfAGoblin.model.character.Weapon;
import edu.chl.LifeOfAGoblin.utils.InputManagerWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author fredrik
 */
public class CharacterFactoryTest {
    private Player player;
    private Minion minion;
    private Node node1;
    private Node node2;

    
    public CharacterFactoryTest() {
    }
    
    
    @Before
    public void setUp() {
        player = new Player();
        minion = new Minion();
        node1 = new Node();
        node2 = new Node();
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
    public void testCreateCharacter() {
        //setup
        CharacterPainter.createCharacter(node1, player);
        CharacterPainter.createCharacter(node2, minion);
        Control c1;
        Control c2;
        
        //tests that ghostControls are added correctly
        try {
            //setup
            c1 = node1.getControl(GhostControl.class);
            c2 = node2.getControl(GhostControl.class);  
            Vector3f measurements1 = ((BoxCollisionShape)((GhostControl)c1).getCollisionShape()).getHalfExtents();
            Vector3f measurements2 = ((BoxCollisionShape)((GhostControl)c2).getCollisionShape()).getHalfExtents();

            //tests that ghostcontrols have a correct shape
            assertTrue(measurements1.x == 1);
            assertTrue(measurements1.y == player.getCollisionHeight());
            assertTrue(measurements1.z == player.getCollisionWidth()); 
            assertTrue(measurements2.x == 1);
            assertTrue(measurements2.y == minion.getCollisionHeight());
            assertTrue(measurements2.z == minion.getCollisionWidth());         
        } catch (NullPointerException ex) {
            fail();
        }
        
        
        
        //tests that modelcontrols are added correctly 
        try {
            //setup
            c1 = node1.getControl(ModelControl.class);
            c2 = node2.getControl(ModelControl.class);
            AbstractCharacter char1 = ((AbstractCharacter)((ModelControl)c1).getModel());
            AbstractCharacter char2 = ((AbstractCharacter)((ModelControl)c2).getModel());
            
            //tests that modelcontrols have the right model
            assertTrue(char1.equals(player));
            assertTrue(char2.equals(minion));
        } 
        catch (NullPointerException ex) {
            fail();
        }
        
        //tests that characterControls are added correctly
        try {
            c1 = node1.getControl(CharacterControl.class);
            c2 = node2.getControl(CharacterControl.class);  
            float height1 = ((CapsuleCollisionShape)((CharacterControl)c1).getCollisionShape()).getHeight();
            float radius1 = ((CapsuleCollisionShape)((CharacterControl)c1).getCollisionShape()).getRadius();
            int axis1 = ((CapsuleCollisionShape)((CharacterControl)c1).getCollisionShape()).getAxis();
            float height2 = ((CapsuleCollisionShape)((CharacterControl)c2).getCollisionShape()).getHeight();
            float radius2 = ((CapsuleCollisionShape)((CharacterControl)c2).getCollisionShape()).getRadius();
            int axis2 = ((CapsuleCollisionShape)((CharacterControl)c2).getCollisionShape()).getAxis();
            
            //tests that CharacterControls have a correct shape
            assertTrue(axis1 == 1);
            assertTrue(height1 == player.getHeight());
            assertTrue(radius1 == player.getWidth()); 
            assertTrue(axis2 == 1);
            assertTrue(height2 == minion.getHeight());
            assertTrue(radius2 == minion.getWidth());
        } 
        catch (NullPointerException ex) {
            fail();
        }       
        
        //tests that a playerhealthcontrol is added to the player
        try {
            //setup
            node1.getControl(PlayerHealthControl.class).setEnabled(true);
        } 
        catch (NullPointerException ex) {
            fail();
        } 
        
        //tests that a playermovecontrol is added to the player
        try {
            //setup
            node1.getControl(PlayerMoveControl.class).setEnabled(true);
        } 
        catch (NullPointerException ex) {
            fail();
        } 
           
        //tests that a npccollisioncontrol is added to the minion
        try {
            //setup
            node2.getControl(NPCCollisionControl.class).setEnabled(true);
        } 
        catch (NullPointerException ex) {
            fail();
        } 
           
        //tests that a npcmovecontrol is added to the minion
        try {
            //setup
            node2.getControl(NPCMoveControl.class).setEnabled(true);
        } 
        catch (NullPointerException ex) {
            fail();
        }
        
        //tests that a weapon is added to the minion
        try {
            //setup
            ((Minion)node2.getControl(ModelControl.class).getModel()).getWeapon().getClass();
        } 
        catch (NullPointerException ex) {
            fail();
            
        }    
        
        //tests that a ghostControl is added to the weapon correctly
        try {
            //setup
            c2 = node2.getChild(0).getControl(GhostControl.class);
            Vector3f measurements2 = ((BoxCollisionShape)((GhostControl)c2).getCollisionShape()).getHalfExtents();
            
            assertTrue(measurements2.z == 1);
            assertTrue(measurements2.y == minion.getWeapon().getCollisionHeight());
            assertTrue(measurements2.x == minion.getWeapon().getCollisionWidth());         
        } 
        catch (NullPointerException ex) {
            fail();
            
        }
        
        //tests that a modelControl is added to the weapon correctly
        try {
            //setup
            node2.getChild(0).getControl(ModelControl.class).setEnabled(true);
            c2 = node2.getChild(0).getControl(ModelControl.class);
            assertTrue(((ModelControl)c2).getModel() instanceof Weapon);
        } 
        catch (NullPointerException ex) {
            fail();
            
        }
        
    }

}