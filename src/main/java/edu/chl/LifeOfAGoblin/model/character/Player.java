package edu.chl.LifeOfAGoblin.model.character;

import edu.chl.LifeOfAGoblin.model.ICollidable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The player class represents the player character in the game. The class
 * contains methods and values related to the player, such as health,
 * jumpStrength, size etc.
 *
 * @author Anton
 */
public class Player extends AbstractCharacter {

    private static final int maxHealth = 5;
    private static final String model = "Goblin2.j3o";
    private static final float height = 1;
    private static final float width = 0.4f;
    private static final float weight = 10;
    private static final float baseDamage = 1;
    private static final float jumpStrength = 14;
    private boolean invulnerable;
    private long invulnerableTime = 1000;
    private Timer timer;

    public Player() {
        super(maxHealth, model, height, width, height, width, weight, baseDamage, jumpStrength);
        this.invulnerable = false;
        timer = new Timer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void collide(ICollidable collided) {
        if (collided instanceof Weapon) {
            this.decreaseHealth();
        }
    }

    @Override
    public void decreaseHealth() {
        if (!isInvulnerable()) {
            super.decreaseHealth();
            setInvulnerable();
        }
    }

    /**
     * Sets whether the player is currently taking damage or not. If
     *
     */
    private void setInvulnerable() {
        if (!isInvulnerable()) {
            invulnerable = true;
            timer.schedule(new InvulnerableController(), invulnerableTime);
        }
    }

    /**
     * Returns whether the player is currently taking damage or not.
     *
     * @return whether the player is currently taking damage or not.
     */
    private boolean isInvulnerable() {
        return this.invulnerable;
    }

    private class InvulnerableController extends TimerTask {
        @Override
        public void run() {
            invulnerable = false;
        }
    }
}
