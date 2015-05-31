/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import edu.chl.LifeOfAGoblin.model.INode;
import edu.chl.LifeOfAGoblin.model.character.Minion;
import edu.chl.LifeOfAGoblin.model.character.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Ulrika
 */
public class ModelControlTest {
    
    private ModelControl mc;
    private INode model;

    @Before
    public void setUp() {
        model = new Minion();
        mc = new ModelControl(model);
    }
    
    @After
    public void tearDown() {
        model = null;
        mc = null;
    }

    @Test
    public void testGetModel() {
        //Tests that the model is returned correctly
        assertTrue("ModelControlTest: Model is not of the correct class when using getModel()", mc.getModel().getClass() == Minion.class);
        assertTrue("ModelControlTest: Model is not the correct object when using getModel()", mc.getModel() == model);
    }

    @Test
    public void testSetModel() {
        INode newModel = new Player();
        mc.setModel(newModel);
        
        //Testing to see that the model is changed properly
        assertFalse("ModelControlTest: Model is not changed correctly by setModel()", mc.getModel() == model);
        assertTrue("ModelControlTest: Model is not changed correctly by setModel()", mc.getModel() == newModel);
    }

    @Ignore("Method does nothing")
    @Test
    public void testControlUpdate() {
    }

    @Ignore("Method does nothing")
    @Test
    public void testControlRender() {
    }
}