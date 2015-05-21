/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeFactory;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.jME3.view.LifeOfAGoblin;
import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.scene.Node;

/**
 *
 * @author fredrik
 */
public class SpawnControlTest {
    private Node lvl;
    private LifeOfAGoblin loag;
    
    public SpawnControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.lvl = new Node();
        this.loag = new LifeOfAGoblin();
       // loag.simpleInitApp();
        Resources.getInstance().initialize(loag.getAssetManager());
        System.out.println(loag.getAssetManager()==null);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSpawn() {
        SpawnControl control = new SpawnControl();
        lvl.addControl(control);
        control.Spawn(1, NodeType.MINION);
    }


}