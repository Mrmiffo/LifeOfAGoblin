/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.controller;

import com.jme3.bullet.control.CharacterControl;
import com.jme3.input.controls.ActionListener;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author Anton
 */
public class PlayerListener extends AbstractControl implements ActionListener{
    
    //private CharacterControl playerControl = spatial.getControl(CharacterControl.class);

    private String  currentDirection;
    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (isPressed){
            if (name.equals("walkRight")){
                faceRight();
                spatial.getControl(CharacterControl.class).setWalkDirection(new Vector3f(0.1f, 0f, 0f));
                currentDirection = name;
            } else if (name.equals("walkLeft")){
                faceLeft();
                spatial.getControl(CharacterControl.class).setWalkDirection(new Vector3f(-0.1f, 0f, 0f));
                currentDirection  = name;
            } else if (name.equals("jump")){
                spatial.getControl(CharacterControl.class).jump();
            } 
        } else if (name.equals(currentDirection)){
            haltPlayer();  
        }
        
//        if (name.equals("walkLeft")){
//            if (isPressed) {
//                faceLeft();
//                spatial.getControl(CharacterControl.class).setWalkDirection(new Vector3f(-0.1f, 0f, 0f));
//            } else if (!isPressed) {
//                haltPlayer();
//            }
//        }
//        
//        if (name.equals("walkRight")){
//            if (isPressed) {
//                faceRight();
//                spatial.getControl(CharacterControl.class).setWalkDirection(new Vector3f(0.1f, 0f, 0f));
//            } else if (!isPressed) {
//                haltPlayer();
//            }
//        }
        
//        if (name.equals("jump") && isPressed){
//            //TODO implement double jump
//            spatial.getControl(CharacterControl.class).jump();
//        }
    }

    @Override
    protected void controlUpdate(float tpf) {
        
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }
    
    private void faceLeft() {
        spatial.getControl(CharacterControl.class).setViewDirection(new Vector3f(-1, 0, 0));
        /*Quaternion turnLeft = new Quaternion();
        turnLeft.fromAngleAxis(-FastMath.PI/2, new Vector3f(0, 1, 0));
        spatial.setLocalRotation(turnLeft);*/
    }
    
    private void faceRight() {
        spatial.getControl(CharacterControl.class).setViewDirection(new Vector3f(1, 0, 0));
        /*Quaternion turnRight = new Quaternion();
        turnRight.fromAngleAxis(FastMath.PI/2, new Vector3f(0, 1, 0));
        spatial.setLocalRotation(turnRight);*/
    }
    
    private  void faceFront() {
        Quaternion turnFront = new Quaternion();
        turnFront.fromAngleAxis(0, new Vector3f(0, 1, 0));
        spatial.setLocalRotation(turnFront);
    }
    
    private void haltPlayer() {
        spatial.getControl(CharacterControl.class).setWalkDirection(Vector3f.ZERO);
    }
    
}
