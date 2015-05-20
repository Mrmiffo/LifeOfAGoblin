/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.Direction;

/**
 *
 * @author kakan
 */
public abstract class AbstractMoveControl extends AbstractControl {
    
    protected Direction currentDirection;
    private CharacterControl characterControl;
    private float stepWidth;
    
    /**
     * Creates a AbstractMoveControl with a step width of 0.1.
     */
    public AbstractMoveControl() {
        this.stepWidth = 0.1f;
    }
    
    /**
     * Creates a AbstractMoveControl with a specified step width.
     * @param stepWidth the wanted step width
     */
    public AbstractMoveControl(float stepWidth) {
        this.stepWidth = stepWidth;
    }

    @Override
    protected void controlUpdate(float tpf) {
        if (characterControl.getPhysicsLocation().z != 0) {
            Vector3f currentLocation = characterControl.getPhysicsLocation();
            characterControl.warp(new Vector3f(currentLocation.x, currentLocation.y, 0));
        }
        
        switch (currentDirection) {
                case LEFT:
                    faceLeft();
                    characterControl.setWalkDirection(new Vector3f(-stepWidth, 0, 0));
                    break;
                case RIGHT:
                    faceRight();
                    characterControl.setWalkDirection(new Vector3f(stepWidth, 0, 0));
                    break;
                case STAND_STILL:
                    haltCharacter();
                    break;
                default:
                    haltCharacter();
                    break;
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }
    
    /**
     * Makes the controlled spatial face to the left.
     */
    protected void faceLeft() {
        characterControl.setViewDirection(Vector3f.UNIT_X.mult(-1));
    }
    
    /**
     * Makes the controlled spatial face to the right.
     */
    protected void faceRight() {
        characterControl.setViewDirection(Vector3f.UNIT_X);
    }
    
    /**
     * Makes the controlled spatial face towards the player (front).
     */
    protected void faceFront() {
        characterControl.setViewDirection(Vector3f.UNIT_Z);
    }
    
    /**
     * Makes the controlled spatial stop moving.
     */
    protected void haltCharacter() {
        characterControl.setWalkDirection(Vector3f.ZERO);
    }
    
    /**
     * Makes the controlled spatial jump.
     */
    protected void jump() {
        characterControl.jump();
    }
    
    @Override
    public void setSpatial(Spatial spatial) {
        super.setSpatial(spatial);
        if (spatial != null) {
            characterControl = spatial.getControl(CharacterControl.class);
        } else {
            characterControl = null;
        }
    }
    
}
