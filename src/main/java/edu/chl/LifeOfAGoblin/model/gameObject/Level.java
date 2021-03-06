package edu.chl.LifeOfAGoblin.model.gameObject;

import java.awt.Color;

/**
 * The level model. Contains the model data of the level and the scene and
 * background sound name.
 *
 * @author Anton
 */
public class Level extends AbstractInanimateObject {

    private int levelNo;
    private String backgroundSound;
    private String levelName;
    private Color skyColor;

    /**
     * Defaul contstructor for the level. Typically called from the LevelManager
     * class. Takes the name of the level and the number of the level. These
     * values typcally only exist in the LevelManager class. The
     * AbstractInanimate object class will use the level name to load the .j3o
     * file.
     *
     * @param levelName the name of the level that should be created
     * @param levelno the player instance to load into the level.
     * @param backgroundSound the file name of the sound to play in the
     * background.
     */
    public Level(String levelName, int levelNo, String backgroundSound, Color skyColor) {
        //Save the scene file to load.
        super(levelName + ".j3o");
        this.levelName = levelName;
        this.levelNo = levelNo;
        this.backgroundSound = backgroundSound;
        this.skyColor = skyColor;
    }
    
    /**
     * Returns the name of the level.
     * @return the namen of the level.
     */
    public String getLevelName(){
        return levelName;
    }

    /**
     * Returns the number of the level.
     * @return the number of the level.
     */
    public int getLevelNo() {
        return levelNo;
    }

    /**
     * Returns the name of the background sound.
     * @return the file name of the sound.
     */
    public String getBackgroundSoundName() {
        return backgroundSound;
    }

    public Color getSkyColor() {
        return new Color(skyColor.getRed(), skyColor.getGreen(), skyColor.getBlue(), skyColor.getAlpha());
    }
}
