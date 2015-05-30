/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.profile;

import com.jme3.input.KeyInput;
import edu.chl.LifeOfAGoblin.utils.SaveLoadManager;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 *
 * @author fredrik
 */
public class ProfileTest {
    private Profile p;
    private Profile mockP;
    
    public ProfileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = new Profile("Test");
        mockP = mock(Profile.class);
    }
    
    @After
    public void tearDown() {
        Profile.getProfiles().clear();
    }

    @Test
    public void testRename() {     
        //tests that method can handle null input
        p.rename(null);
        
        //tests that profile was saved
        mockP.rename("newName");
        verify(mockP, times(1)).rename("newName");
        
        //tests that name of profile is changed
        p.rename("newName");
        assertTrue(p.getProfileName().equals("newName"));
        assertTrue(SaveLoadManager.getInstance().getSavedFiles(null).contains("newName"));
        
        //tests that method can handle empty strings
        p.rename("");
        assertFalse(p.getProfileName().equals(""));
        assertFalse(SaveLoadManager.getInstance().getSavedFiles(null).contains(""));

        
    }

    @Test
    public void testAddCustomBinding() {
        //setup
        ArrayList<Keybind> list1 = new ArrayList();
        Keybind testKeyBind1 = new Keybind(InputDevice.KEYBOARD, 1);
        Keybind testKeyBind2 = new Keybind(InputDevice.MOUSE_BUTTON, 1);
        Keybind testKeyBind3 = new Keybind(InputDevice.KEYBOARD, 0);
        Keybind testKeyBind4 = new Keybind(InputDevice.MOUSE_BUTTON, 0);
        Keybind testKeyBind5 = new Keybind(InputDevice.KEYBOARD, -1);
        Keybind testKeyBind6 = new Keybind(InputDevice.MOUSE_BUTTON, -1);

        //tests that profile is saved
        mockP.addCustomBinding(Actions.JUMP, list1);
        verify(mockP, times(1)).addCustomBinding(Actions.JUMP, list1);
        
        //tests if Keybind is added
        list1.add(testKeyBind1);
        p.addCustomBinding(Actions.JUMP, list1);
        list1.clear();
        list1.add(testKeyBind2);
        p.addCustomBinding(Actions.OPEN_MENU, list1);
        assertTrue(Actions.JUMP.getKeyCodes().contains(testKeyBind1));
        assertTrue(Actions.OPEN_MENU.getKeyCodes().contains(testKeyBind2));        
        
        //tests if method can handle negative input
        list1.clear();
        list1.add(testKeyBind5);
        p.addCustomBinding(Actions.WALK_LEFT, list1);
        list1.clear();
        list1.add(testKeyBind6);
        p.addCustomBinding(Actions.WALK_RIGHT, list1);
        assertTrue(Actions.WALK_LEFT.getKeyCodes().contains(testKeyBind5));
        assertTrue(Actions.WALK_RIGHT.getKeyCodes().contains(testKeyBind6));
        
        //tests if method can handle zero input
        list1.clear();
        list1.add(testKeyBind3);
        p.addCustomBinding(Actions.WALK_LEFT, list1);
        list1.clear();
        list1.add(testKeyBind4);
        p.addCustomBinding(Actions.WALK_RIGHT, list1);
        assertTrue(Actions.WALK_LEFT.getKeyCodes().contains(testKeyBind3));
        assertTrue(Actions.WALK_RIGHT.getKeyCodes().contains(testKeyBind4));
    
        //tests if method can add several integers
        list1.clear();
        list1.add(testKeyBind6);
        list1.add(testKeyBind5);
        list1.add(testKeyBind4);
        p.addCustomBinding(Actions.JUMP, list1);
        assertTrue(Actions.JUMP.getKeyCodes().contains(testKeyBind4));
        assertTrue(Actions.JUMP.getKeyCodes().contains(testKeyBind5));
        assertTrue(Actions.JUMP.getKeyCodes().contains(testKeyBind6));

        //tests that method can handle null input
        p.addCustomBinding(null, null);
    }
    
    @Test
    public void testResetDefaultBindings() {
        //setup
        
            class TestDefaultKey{
                private Actions action;
                private ArrayList<Integer>  keys;
            public TestDefaultKey(Actions action, ArrayList<Integer> keys){
                this.action = action;
                this.keys = keys;
                
            }
            public ArrayList<Integer> getKey(){
                return this.keys;
            }
            public Actions getAction(){
                return this.action;
            }
            
        }
            
        ArrayList<Integer> jumpList = new ArrayList();
        jumpList.add(KeyInput.KEY_W);
        jumpList.add(KeyInput.KEY_SPACE);
        ArrayList<Integer> menuList = new ArrayList();
        menuList.add(KeyInput.KEY_P);
        ArrayList<Integer> leftList = new ArrayList();
        leftList.add(KeyInput.KEY_A);
        ArrayList<Integer> rightList = new ArrayList();
        rightList.add(KeyInput.KEY_D);
        
        TestDefaultKey jump = new TestDefaultKey(Actions.JUMP, jumpList);
        TestDefaultKey menu = new TestDefaultKey(Actions.OPEN_MENU, menuList);
        TestDefaultKey left = new TestDefaultKey(Actions.WALK_LEFT, leftList);
        TestDefaultKey right = new TestDefaultKey(Actions.WALK_RIGHT, rightList);    
        ArrayList<TestDefaultKey> defaultKeyList = new ArrayList();
        defaultKeyList.add(jump);
        defaultKeyList.add(menu);
        defaultKeyList.add(left);
        defaultKeyList.add(right);
        
        ArrayList<Actions> actionsList= new ArrayList();
        actionsList.add(Actions.JUMP);
        actionsList.add(Actions.OPEN_MENU);
        actionsList.add(Actions.WALK_LEFT);
        actionsList.add(Actions.WALK_RIGHT);

        ArrayList<Keybind> list1 = new ArrayList();
        Keybind testKeyBind1 = new Keybind(InputDevice.KEYBOARD, 1);
        list1.add(testKeyBind1);
        //tests that profile was saved
        mockP.resetDefaultBindings();
        verify(mockP, times(1)).resetDefaultBindings();
        
        //tests that keybindings were reset
        p.addCustomBinding(Actions.JUMP, list1);
        p.addCustomBinding(Actions.OPEN_MENU, list1);
        p.addCustomBinding(Actions.WALK_LEFT, list1);
        p.addCustomBinding(Actions.WALK_RIGHT, list1);
        p.resetDefaultBindings();
        assertFalse(Actions.JUMP.getKeyCodes().contains(testKeyBind1));
        assertFalse(Actions.OPEN_MENU.getKeyCodes().contains(testKeyBind1));
        assertFalse(Actions.WALK_LEFT.getKeyCodes().contains(testKeyBind1));
        assertFalse(Actions.WALK_RIGHT.getKeyCodes().contains(testKeyBind1));
        for(TestDefaultKey tdk: defaultKeyList){
            for(Actions A: actionsList){
                if(tdk.getAction().equals(A)&& tdk.keys.size()>1){
                    if((A.getKeyCodes().get(0).getKey()!=tdk.keys.get(0)&&A.getKeyCodes().get(0).getKey()!=tdk.keys.get(1))
                            || (A.getKeyCodes().get(1).getKey()!=tdk.keys.get(0)&&A.getKeyCodes().get(1).getKey()!=tdk.keys.get(1))){
                        fail();
                    }
                }
                if(tdk.getAction().equals(A)){
                    if(A.getKeyCodes().get(0).getKey()!=tdk.keys.get(0)){
                        fail();
                    }
                }
            }
        }  
    }


    @Test
    public void testSetActiveProfile_Profile() {
        //tests that active profile is changed.
        Profile.setActiveProfile(p);
        assertTrue(Profile.getActiveProfile().equals(p));
        
        //tests that method can handle null input.
        Profile.setActiveProfile((Profile)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetActiveProfile_String() {
        //tests that active profile is changed.
        Profile.addProfile(p);
        Profile.setActiveProfile("Test");
        assertTrue(Profile.getActiveProfile().getProfileName().equals("Test"));
    
        //tests that method can handle an empty string
        Profile.setActiveProfile("");
        assertTrue(Profile.getActiveProfile().getProfileName().equals("Test"));
        
        //tests that method can handle a string that is no the name of a profile
        Profile.setActiveProfile("not the name of a profile");
        assertTrue(Profile.getActiveProfile().getProfileName().equals("Test"));
    
        //tests that method can handle null input
        Profile.setActiveProfile((String) null);
    }


    @Test
    public void testAddProfile() {
        //setup
        Profile s = new Profile("testprofile2");
        //tests that a profile is added to the list of profiles
        Profile.addProfile(p);
        assertTrue(Profile.getProfiles().contains(p));
        
        //tests that you can add more than one profile
        Profile.addProfile(s);
        assertTrue(Profile.getProfiles().contains(s));
        
        //tests that method can handle null input
        Profile.addProfile(null);
    }

    @Test
    public void testRemoveProfile() {
        //tests that profile is removed
        Profile.addProfile(p);
        Profile.removeProfile(p);
        assertFalse(Profile.getProfiles().contains(p));
        
    }

    @Test
    public void testGetProfileName() {
    }

    @Test
    public void testGetProgress() {
    }

    @Test
    public void testGetProfile() {
    }

    @Test
    public void testGetActiveProfile() {
    }

    @Test
    public void testGetIsActiveProfile() {
    }

    @Test
    public void testSaveProfile() {
    }

    @Test
    public void testGetProfiles() {
    }
}