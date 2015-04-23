/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;



import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import edu.chl.LifeOfAGoblin.controller.PlayerAttackControl;
import edu.chl.LifeOfAGoblin.controller.PlayerMoveControl;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;

/**
 *
 * @author Anton
 */
public class Player extends AbstractCharacter {
    private float collisionShapeHeight = 1f;
    private float collisionShapeWidth = 0.5f;
    
    public Player(int health, int maxHealth, PlayerMoveControl pl){
        super("Goblin", health, maxHealth);
        //Setting upp collision shape and character control:
        CapsuleCollisionShape shape = new CapsuleCollisionShape(collisionShapeWidth, collisionShapeHeight, 1);
        CharacterControl mover = new CharacterControl(shape, 0.05f);
        //Setting object data:
        character.setUserData("objectType", "Player");
        mover.setJumpSpeed(12);
        character.getChild(0).setLocalTranslation(new Vector3f(0,-collisionShapeHeight,0));
        //Attaching controls:
        character.addControl(mover);
        character.addControl(new PlayerAttackControl());
        character.addControl(pl);
    }
            
}
