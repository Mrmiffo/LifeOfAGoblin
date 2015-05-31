/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.system.JmeSystem;
import edu.chl.LifeOfAGoblin.jME3.game.LifeOfAGoblin;
import edu.chl.LifeOfAGoblin.utils.Resources;
import edu.chl.LifeOfAGoblin.utils.StateManagerWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Ulrika
 */
public class NodeFactoryTest {
    private LifeOfAGoblin loag;
    AssetManager assetManager = null;
    AppStateManager stateManager = null;
    
    public NodeFactoryTest() {
    }
    
    @Before
    public void setUp() {
        this.loag = new LifeOfAGoblin();
        this.assetManager = JmeSystem.newAssetManager(Thread.currentThread().getContextClassLoader().getResource("com/jme3/asset/Desktop.cfg"));
        this.stateManager = new AppStateManager(loag);
        StateManagerWrapper.getInstance().initialize(stateManager);
        Resources.getInstance().initialize(assetManager);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreateNode() {
        
    }

    @Test
    public void testCreateLevelNode() {

}
}