package edu.chl.LifeOfAGoblin.jME3.controller.character;

import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.character.Direction;

/**
 * An abstract class for controlling character movement.
 * @author Ulrika
 */
public abstract class AbstractMoveControl extends AbstractControl {

    protected Direction currentDirection;
    private CharacterControl characterControl;
    protected float stepWidth;

    /**
     * Creates an AbstractMoveControl with a step width of 0.1.
     */
    public AbstractMoveControl() {
        this(0.1f);
    }

    /**
     * Creates an AbstractMoveControl with a specified step width.
     *
     * @param stepWidth the wanted step width
     */
    public AbstractMoveControl(float stepWidth) {
        this.stepWidth = stepWidth;
        this.currentDirection = Direction.STAND_STILL;
    }

    /**
     * Sets the walking direction of the controlled character.
     * @param tpf ticks per frame
     */
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
    private void faceLeft() {
        characterControl.setViewDirection(Vector3f.UNIT_X.mult(-1));
    }

    /**
     * Makes the controlled spatial face to the right.
     */
    private void faceRight() {
        characterControl.setViewDirection(Vector3f.UNIT_X);
    }

    /**
     * Makes the controlled spatial face towards the player (front).
     */
    private void faceFront() {
        characterControl.setViewDirection(Vector3f.UNIT_Z);
    }

    /**
     * Makes the controlled spatial stop moving.
     */
    private void haltCharacter() {
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
