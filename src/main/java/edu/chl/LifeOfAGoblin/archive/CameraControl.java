/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.archive;

import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author kakan
 */
public class CameraControl extends AbstractControl {
    private boolean isFixed;
    private Camera cam;
    private Vector3f defaultDistanceToPlayer = new Vector3f(0, 3.8f, 10);
    private Vector3f currentFixedPoint;
    private int numberOfMoveSteps;
    private int moveStepsCompleted;
    private Vector3f stepDistance;
    
    @Override
    protected void controlUpdate(float tpf) {
        if (!isFixed) {
            cam.setLocation(getPlayerPos().add(defaultDistanceToPlayer));
        } else {    //Player enters radius, sets isFixed to true
            //if Player has left radius --> isFixed to false
            
            moveCameraOneStep();
            
        }
    }
    
//    private void setFixedCamera(Vector3f origin, int borderRadius, int cameraMoveSteps) {
//        currentFixedPoint = origin;
//        //calculate border
//        numberOfMoveSteps = cameraMoveSteps;
//        moveStepsCompleted = 0;   
//    }
    
    private void moveCameraOneStep() {
        if (moveStepsCompleted == 0) {
            Vector3f totalDistance = currentFixedPoint.subtract(cam.getLocation());
            stepDistance = totalDistance.divide(numberOfMoveSteps);
        }
        if (moveStepsCompleted < numberOfMoveSteps) {           
            cam.setLocation(cam.getLocation().add(stepDistance));       
            moveStepsCompleted++;
        }
    }
    
    private Vector3f getPlayerPos() {
        return new Vector3f();
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
