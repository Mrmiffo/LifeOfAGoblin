package edu.chl.LifeOfAGoblin.model.character;

/**
 * The basic boss NPC class.
 * @author Anton
 */
public abstract class Boss extends AbstractNPC {
    
    private static final int maxHealth = 100;
    private static final float aggressionRange = 4;
    private static final String model = "";
    private static final float height = 10;
    private static final float width = 7;
    private static final float collisionHeight = 1;
    private static final float collisionWidth = aggressionRange * 2;
    private static final float weight = 1000;
    private static final float baseDamage = 10;
    private static final float jumpStrength = 0;
    
    /**
     * {@inheritDoc}
     */
    public Boss(){
        this("PLAYER");
    }
    
    /**
     * {@inheritDoc}
     */
    public Boss(String target) {
        super(maxHealth, model, height, width, collisionHeight,collisionWidth, 
                weight, baseDamage, jumpStrength, target.toUpperCase(),
                aggressionRange, new MeleeWeapon());
    }
}
