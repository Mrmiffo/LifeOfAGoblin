package edu.chl.LifeOfAGoblin.jME3.controller.character;

import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.jME3.controller.ModelControl;
import edu.chl.LifeOfAGoblin.model.character.AIAction;
import edu.chl.LifeOfAGoblin.model.character.Direction;
import edu.chl.LifeOfAGoblin.model.character.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.INode;

/**
 * A control for controlling NPC movement.
 * @author Ulrika
 */
public class NPCMoveControl extends AbstractMoveControl {

    private AbstractNPC npcModel;
    private float maximumIdleMoveRange;
    private float currentMoveRange;

    /**
     * Creates a NPCMoveControl with a default move range and no connected
     * spatial.
     */
    public NPCMoveControl() {
        this(20); //Default start value of idleMoveRange
    }

    /**
     * Creates a NPCMoveControl with a specified move range and no connected
     * spatial.
     * @param idleMoveRange the move range
     */
    public NPCMoveControl(float idleMoveRange) {
        super(0.09f);
        this.maximumIdleMoveRange = idleMoveRange;
        this.currentMoveRange = maximumIdleMoveRange / 2;
        this.currentDirection = Direction.LEFT;
    }

    @Override
    public void controlUpdate(float tpf) {
        if (npcModel != null) {
            AIAction action = npcModel.getAIAction();
            
            switch (action) {
                case IDLE:
                    if (Math.abs(currentMoveRange) < 0.05f) {
                        currentDirection = (currentDirection == Direction.LEFT)
                                ? Direction.RIGHT : Direction.LEFT;
                        currentMoveRange = maximumIdleMoveRange;
                    } else {
                        currentMoveRange -= stepWidth;
                    }
                    break;
                case MOVETOTARGET:
                    currentDirection = npcModel.getTargetDirection();
                    break;
                case HALT:
                    currentDirection = Direction.STAND_STILL;
                    break;
                default:
                    currentDirection = Direction.STAND_STILL;
                    break;
            }
            super.controlUpdate(tpf);
        }
    }

    @Override
    public void setSpatial(Spatial spatial) {
        super.setSpatial(spatial);
        INode n = this.spatial.getControl(ModelControl.class).getModel();
        if (n instanceof AbstractNPC) {
            npcModel = (AbstractNPC) n;
        }
    }
}
