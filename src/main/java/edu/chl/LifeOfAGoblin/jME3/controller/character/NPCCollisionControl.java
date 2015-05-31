package edu.chl.LifeOfAGoblin.jME3.controller.character;

import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.jME3.controller.ModelControl;
import edu.chl.LifeOfAGoblin.model.character.Direction;
import edu.chl.LifeOfAGoblin.model.character.AbstractCharacter;
import edu.chl.LifeOfAGoblin.model.character.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.INode;
import java.util.List;

/**
 * A control for updating NPC model information about collisions.
 * @author Ulrika
 */
public class NPCCollisionControl extends AbstractControl {

    /**
     * Updates the information in the model about targets.
     * @param collided the object with which the GhostControl has collided with
     */
    private void updateCollisionInfo(Spatial npc, Spatial collided) {
        if (npc != collided && collided.getControl(ModelControl.class).getModel() instanceof AbstractCharacter) {
            INode n = npc.getControl(ModelControl.class).getModel();
            AbstractNPC npcModel = (AbstractNPC) n;

            Vector3f npcLocation = npc.getControl(CharacterControl.class).getPhysicsLocation();

            float distance;
            Direction direction;
            float npcX = npcLocation.getX();
            float collidedX = collided.getControl(CharacterControl.class).getPhysicsLocation().getX();
            if (npcX > collidedX) {
                distance = npcX - collidedX;
                direction = Direction.LEFT;
            } else {
                distance = collidedX - npcX;
                direction = Direction.RIGHT;
            }

            npcModel.updateAIAction(FastMath.abs(distance), direction, ((String) collided.getUserData("nodeType")));
        }
    }

    @Override
    protected void controlUpdate(float f) {
        List<PhysicsCollisionObject> overlapping = this.spatial.getControl(GhostControl.class).getOverlappingObjects();
        for (PhysicsCollisionObject pco : overlapping) {
            Object userObject = pco.getUserObject();
            if (userObject.getClass() == Node.class) {
                Node node = (Node) userObject;
                if (node.getControl(ModelControl.class) != null) {
                    updateCollisionInfo(this.spatial, node);
                }
            }
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        //Do nothing
    }
}
