/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.app.state.AppStateManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import edu.chl.LifeOfAGoblin.utils.Resources;
import edu.chl.LifeOfAGoblin.jME3.game.LifeOfAGoblin;
import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.jme3.system.JmeSystem;
import edu.chl.LifeOfAGoblin.model.character.Minion;
import edu.chl.LifeOfAGoblin.utils.StateManagerWrapper;

/**
 *
 * @author fredrik
 */
public class SpawnControlTest {
    private Node lvl;
    private LifeOfAGoblin loag;
    AssetManager assetManager = null;
    AppStateManager stateManager = null;
    
    public SpawnControlTest() {
    }
    @Before
    public void setUp() {
        this.lvl = new Node();
        this.loag = new LifeOfAGoblin();
        this.assetManager = JmeSystem.newAssetManager(Thread.currentThread().getContextClassLoader().getResource("com/jme3/asset/Desktop.cfg"));
        this.stateManager = new AppStateManager(loag);
        StateManagerWrapper.getInstance().initialize(stateManager);
        Resources.getInstance().initialize(assetManager);
    }
    
    @After
    public void tearDown() {
//        for(PhysicsGhostObject obj: ((BulletAppState)StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class)).getPhysicsSpace().getGhostObjectList()){
//            PhysicsWrapper.getInstance().remove(obj);
//        }
//
//        for(PhysicsCharacter obj: ((BulletAppState)StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class)).getPhysicsSpace().getCharacterList()){
//            PhysicsWrapper.getInstance().remove(obj);
//        }
//        for(PhysicsRigidBody obj: ((BulletAppState)StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class)).getPhysicsSpace().getRigidBodyList()){
//            PhysicsWrapper.getInstance().remove(obj);
//        }        
     }

    @Test
    public void testInitialize() {
    }

    @Test
    public void testControlUpdate() {
    }

    @Test
    public void testControlRender() {
    }
}