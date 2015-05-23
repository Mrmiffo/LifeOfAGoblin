/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractInanimateObject;
import java.util.ArrayList;
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
public class LevelListTest {
    
    public LevelListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        for( Level lvl: LevelList.getList()){
            LevelList.removeLevel(lvl);
    }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddLevel_Level() {
        // setup 
        Level lvl1 = new Level("Level1", 1,"");
        AbstractInanimateObject lvl2 = new Level("testScene", 2,"");
        
        // tests that a lvl can be added to the levelList
        LevelList.addLevel(lvl1);
        assertTrue(LevelList.getList().contains(lvl1));
        LevelList.addLevel((Level)lvl2);
        assertTrue(LevelList.getList().contains(lvl2));
        
        // tests that you cannot add an already existing lvl, should   
        // throw IllegalArgumentException
        try{
            LevelList.addLevel(lvl1);
            fail();
        }
        catch (Exception ex){
            assertTrue(ex instanceof IllegalArgumentException);
        }
        
        
    }     

    @Test
    public void testAddLevel_Level_int() {
        //setup
        Level lvl1 = new Level("Level1", 1,"");
        AbstractInanimateObject lvl2 = new Level("testScene", 2,"");
        Level lvl3 = new Level("Level1", 3,"");
        
        //tests that you can add a lvl in a position
        LevelList.addLevel(lvl1, 1);
        LevelList.addLevel((Level)lvl2, 2);
        assertTrue(LevelList.getList().get(1).equals(lvl1));
        assertTrue(LevelList.getList().get(2).equals(lvl2));
        
        // tests that you cannot add an already existing lvl, should   
        // throw IllegalArgumentException
        try{
            LevelList.addLevel(lvl1, 1);
            fail();
        }
        catch (Exception ex){
            assertTrue(ex instanceof IllegalArgumentException);
        }
        
        // tests that the list can handle additions on the same 
        // position
        LevelList.addLevel(lvl3, 1);
        assertTrue(LevelList.getList().get(1).equals(lvl3));
        
        // tests that the LevelList can handle negative and zero positions
        // should throw IndexOutOfBoundsException
        setUp();
        try{
            LevelList.addLevel(lvl1, 0);
            LevelList.addLevel((Level)lvl2, -1);
            fail();
        }
        catch (Exception ex){
            assertTrue(ex instanceof IndexOutOfBoundsException);
        }
    }

    @Test
    public void testRemoveLevel_Level() {
        //setup
        Level lvl1 = new Level("Level1", 1,"");
        
        //tests that you can remove a lvl
        LevelList.addLevel(lvl1);
        LevelList.removeLevel(lvl1);
        assertFalse(LevelList.getList().contains(lvl1));
        
        //tests that the levellist can handle removing levels that are
        //that are not in the list
        LevelList.removeLevel(new Level("Level1", 1,""));

    }

    @Test
    public void testRemoveLevel_int() {
        //setup
        Level lvl1 = new Level("Level1", 1,"");
        
        //tests that you can remove a lvl using its position in the list
        LevelList.addLevel(lvl1);
        LevelList.removeLevel(LevelList.getList().indexOf(lvl1));
        
        //tests that the levellist can handle negative, zero and larger 
        //than its size input
        //should throw IndexOutOfBoundsException
       try{
            LevelList.removeLevel(0);
            LevelList.removeLevel(-5);
            LevelList.removeLevel(5);
            fail();
        }
        catch (Exception ex){
            assertTrue(ex instanceof IndexOutOfBoundsException);
        }
    }
    

    @Test
    public void testGetNext() {
        //setup
        Level lvl1 = new Level("Level1", 1 ,"");
        AbstractInanimateObject lvl2 = new Level("testScene", 2, "");
        
        //tests that you can get the level that is after the given level
        //in the list
        LevelList.addLevel(lvl1);
        LevelList.addLevel((Level)lvl2);
        assertTrue(LevelList.getNext(lvl1).equals(lvl2));
        
        //tests that you cannot get a level when you ask for the level after
        //a lvl that does not exist in the list
        assertFalse(LevelList.getNext(new Level("Level1", 1, "")) instanceof Level);
        
        //tests that you cannot get a level when you ask for the level after
        //the last level in the list 
        assertFalse(LevelList.getNext((Level)lvl2) instanceof Level);

    }

    @Test
    public void testGetLevel() {
        //setup
        Level lvl1 = new Level("Level1", 1,"");
        
        //tests that you can get a level from a given position
        LevelList.addLevel(lvl1);
        assertTrue(LevelList.getLevel(1).equals(lvl1));
        
        //tests that the levellist can handle negative, zero and larger 
        //than its size input
        //should throw IndexOutOfBoundsException
       try{
            LevelList.getLevel(0);
            LevelList.getLevel(-5);
            LevelList.getLevel(5);
            fail();
        }
        catch (Exception ex){
            assertTrue(ex instanceof IndexOutOfBoundsException);
        }
    }

    @Test
    public void testGetPosition() {
        //setup
        Level lvl1 = new Level("Level1", 1, "");
        Level lvl2 = new Level("Level1", 1,"");
        
        //tests that you can get the correct Position of a given lvl
        LevelList.addLevel(lvl1);
        LevelList.addLevel(lvl2);
        assertTrue(LevelList.getPosition(lvl1)==1);
        assertTrue(LevelList.getPosition(lvl2)==2);
        
        //tests that you cannot get a position when a level not in the list
        //is given
        assertFalse(LevelList.getPosition(new Level("Level1", 1, ""))>0);

    }
    
    @Test
    public void testGetList(){
        //setup
        Level lvl1 = new Level("Level1", 1,"");
        
        //tests that you cannot change the list from another class
        
        ArrayList<Level> list = LevelList.getList();
        list.add(lvl1);
        assertTrue(LevelList.getList().isEmpty()); 
    }
}