/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.scene.Node;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Anton
 */
public class TestPlayer {
    
    public TestPlayer() {
    }

    @Before
    public void before(){
        
    }
    
    @Test//(expected=NullPointerException.class)
    public void testNewPlayer(){
        Player test = new Player(100, 100, null);
        Node n = test.getNode();
        assertTrue(n != null);
    }
}