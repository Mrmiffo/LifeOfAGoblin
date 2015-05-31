package edu.chl.LifeOfAGoblin.utils;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsTickListener;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.bullet.control.PhysicsControl;
import com.jme3.bullet.control.RigidBodyControl;

/**
 * A wrapper for the BulletAppState responsible for the in game physics.
 * @author fredrik
 */
public class PhysicsWrapper {

    private static PhysicsWrapper instance;
    private BulletAppState bulletAppState;

    /**
     * Creates an instance of PhysicsWrapper.
     */
    private PhysicsWrapper() {
        bulletAppState = new BulletAppState();
        StateManagerWrapper.getInstance().attachState(bulletAppState);
    }

    /**
     * Returns the singleton instance of PhysicsWrapper.
     * @return the instance of PhysicsWrapper
     */
    public static synchronized PhysicsWrapper getInstance() {
        if (instance == null) {
            instance = new PhysicsWrapper();
        }
        return instance;
    }

    /**
     * Adds a physics control to the physics space.
     * @param control the control to add
     */
    public void addControl(PhysicsControl control) {
        //This check is supposed to be done in jME3 as it accepts any type of object, but if the object is missing the collision shape it will throw an error.
        if ((control instanceof GhostControl && ((GhostControl) control).getCollisionShape() != null)
                || (control instanceof RigidBodyControl && ((RigidBodyControl) control).getCollisionShape() != null)
                || (control instanceof CharacterControl && ((CharacterControl) control).getCollisionShape() != null)) {
            this.bulletAppState.getPhysicsSpace().add(control);
        }

    }

    /**
     * Adds a collision listener to the physics space.
     * @param listener the listener to add
     */
    public void addCollisionListener(PhysicsCollisionListener listener) {
        this.bulletAppState.getPhysicsSpace().addCollisionListener(listener);
    }

    /**
     * Removes an object from the physics space.
     * @param object the object to remove
     */
    public void remove(PhysicsCollisionObject object) {
        if (object != null) {
            this.bulletAppState.getPhysicsSpace().remove(object);
        }
    }

    /**
     * Adds a tick listener to the physics space.
     * @param listener the listener to add
     */
    public void addTickListener(PhysicsTickListener listener) {
        this.bulletAppState.getPhysicsSpace().addTickListener(listener);
    }
}
