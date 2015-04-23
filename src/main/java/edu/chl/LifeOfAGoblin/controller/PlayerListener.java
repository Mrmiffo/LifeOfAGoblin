package edu.chl.LifeOfAGoblin.controller;

import com.jme3.bullet.control.CharacterControl;
import com.jme3.input.controls.ActionListener;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author Anton
 */
public class PlayerListener extends AbstractControl implements ActionListener{
    
    private CharacterControl playerControl;

    private String  currentDirection;
    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (isPressed){
            switch (name) {
                case "walkRight":
                    faceRight();
                    playerControl.setWalkDirection(new Vector3f(0.1f, 0f, 0f));
                    currentDirection = name;
                    break;
                case "walkLeft":
                    faceLeft();
                    playerControl.setWalkDirection(new Vector3f(-0.1f, 0f, 0f));
                    currentDirection  = name;
                    break; 
                case "jump":
                    spatial.getControl(CharacterControl.class).jump();
                    break;
            }
        } else if (name.equals(currentDirection)){
            haltPlayer();  
        }
    }

    @Override
    protected void controlUpdate(float tpf) {

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
    
}
