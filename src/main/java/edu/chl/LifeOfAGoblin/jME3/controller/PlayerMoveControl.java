package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.jME3.controller.interfaces.IKeyListener;
import edu.chl.LifeOfAGoblin.model.KeyBindings;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anton
 */
public class PlayerMoveControl extends AbstractControl implements IKeyListener{
    
    private boolean right;
    private boolean left;
    
    private CharacterControl playerControl;

    

    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.equals(KeyBindings.KeyBind.WALK_RIGHT.getKeyText())){
            if (isPressed) {
                right = true;
            } else {
                right = false;
            }
        } else if (name.equals(KeyBindings.KeyBind.WALK_LEFT.getKeyText())){
            if (isPressed) {
                left = true;
            } else {
                left = false;
            }
        } else if (name.equals(KeyBindings.KeyBind.JUMP.getKeyText())){
            playerControl.jump();
        }
    }

    @Override
    protected void controlUpdate(float tpf) {
        if (right) {
            faceRight();
            playerControl.setWalkDirection(new Vector3f(0.1f, 0f, 0f));
        } else if (left) {
            faceLeft();
            playerControl.setWalkDirection(new Vector3f(-0.1f, 0f, 0f));
        } else {
            haltPlayer();
        }
        
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }
    
    private void faceLeft() {
        playerControl.setViewDirection(new Vector3f(-1, 0, 0));
    }
    
    private void faceRight() {
        playerControl.setViewDirection(new Vector3f(1, 0, 0));
    }
    
    private  void faceFront() {
        playerControl.setViewDirection(new Vector3f(0, 0, 1));
    }
    
    private void haltPlayer() {
        playerControl.setWalkDirection(Vector3f.ZERO);
    }
    
    @Override
    public void setSpatial(Spatial spatial) {
        super.setSpatial(spatial);
        if (spatial != null) {
            playerControl = spatial.getControl(CharacterControl.class);
        } else {
            playerControl = null;
        }
    } 

    @Override
    public List<KeyBindings.KeyBind> getKeyBinds() {
        List<KeyBindings.KeyBind> binds = new ArrayList<>();
        binds.add(KeyBindings.KeyBind.JUMP);
        binds.add(KeyBindings.KeyBind.WALK_LEFT);
        binds.add(KeyBindings.KeyBind.WALK_RIGHT);
        return binds;
    }
    
}
