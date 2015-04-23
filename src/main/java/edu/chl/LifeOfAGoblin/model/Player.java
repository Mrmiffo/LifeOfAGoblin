/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;



import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import edu.chl.LifeOfAGoblin.controller.PlayerAttackControl;
import edu.chl.LifeOfAGoblin.controller.PlayerListener;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;

/**
 *
 * @author Anton
 */
public class Player extends AbstractCharacter {
    
    public Player(int health, int maxHealth, PlayerListener pl){
        super("Goblin", health, maxHealth);
        character.setUserData("objectType", "Player");
        CapsuleCollisionShape shape = new CapsuleCollisionShape(1f, 1f, 1);
        CharacterControl mover = new CharacterControl(shape, 0.05f);
        mover.setJumpSpeed(10);
        mover.setFallSpeed(30);
        mover.setGravity(30);
        character.addControl(mover);
        character.addControl(new PlayerAttackControl());
        character.addControl(pl);
    }
            
}
