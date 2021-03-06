package edu.chl.LifeOfAGoblin.jME3.game;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.audio.AudioNode;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.jME3.controller.nifty.GameHudController;
import edu.chl.LifeOfAGoblin.utils.IKeyListener;
import edu.chl.LifeOfAGoblin.model.gameObject.Level;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeFactory;
import edu.chl.LifeOfAGoblin.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.GameHud;
import edu.chl.LifeOfAGoblin.model.profile.Actions;
import edu.chl.LifeOfAGoblin.utils.LevelManager;
import edu.chl.LifeOfAGoblin.utils.StateManagerWrapper;
import java.awt.Color;

/**
 * The GameAppState is the state in which the game itself is run and
 * initialized.
 *
 * @author Anton
 */
public class GameAppState extends AbstractAppState implements IKeyListener {

    private Node rootNode;
    private Application app;
    private Level level;
    private Node levelNode;
    private GameHud hud;
    private boolean isPaused;
    private final Actions[] actions = new Actions[]{
        Actions.PAUSE
    };

    /**
     * Creates a GameAppState with a default first level
     */
    public GameAppState() {
        this(1);
    }

    /**
     * Creates a GameAppState with a specified first level
     */
    public GameAppState(int firstLevelToStart) {
        setLevelToStart(firstLevelToStart);
        hud = new GameHud();
        NiftyGUIWrapper.getInstance().addScreen(hud.getScreenName(), hud.getScreen());
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        rootNode = ((SimpleApplication) app).getRootNode();
        this.app = app;
        InputManagerWrapper.getInstance().registerListener(this);
    }

    @Override
    public void cleanup() {
        super.cleanup();
        detachPhysics();
        stopMusic();
        rootNode.detachAllChildren();
    }

    /**
     * Stops the music in the level.
     */
    private void stopMusic() {
        if (levelNode != null && levelNode.getChildren().size() > 0) {
            for (Spatial node : (levelNode.getChildren())) {
                if (node instanceof AudioNode) {
                    ((AudioNode) node).stop();
                }
            }
        }
    }

    /**
     * Updates the next level that should start.
     *
     * @param levelno the number of the next level
     */
    public void setLevelToStart(int levelno) {
        level = LevelManager.getInstance().getLevel(levelno);
    }

    /**
     * Starts the level specified by setLevelToStart.
     */
    public void startLevel() {
        setSkyColor();
        attachPhysics();
        displayHud();
        levelNode = NodeFactory.createLevelNode(level, app.getCamera());
        rootNode.attachChild(levelNode);
    }

    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.equals(Actions.PAUSE.toString()) && isPressed) {
            pause();
        }
    }

    /**
     * A method used to pause the game.
     */
    private void pause() {
        StateManagerWrapper sm = StateManagerWrapper.getInstance();
        if (isPaused) {
            GameHudController.turnOpaque();
            isPaused = false;
            setEnabled(true);
            sm.activateState(sm.getAvailableState(BulletAppState.class));
        } else {
            GameHudController.turnGray();
            isPaused = true;
            setEnabled(false);
            sm.deactivateState(sm.getAvailableState(BulletAppState.class));
        }
    }

    @Override
    public Actions[] getKeyBinds() {
        return (Actions[]) actions.clone();
    }

    /**
     * Attach the physics state.
     */
    private void attachPhysics() {
        StateManagerWrapper.getInstance().attachState(StateManagerWrapper.getInstance().getAvailableState(BulletAppState.class));
    }

    /**
     * Display the game hud.
     */
    private void displayHud() {
        NiftyGUIWrapper.getInstance().goToScreen(hud.getScreenName());
    }

    /**
     * Detach the physics to deactivate all the physical objects.
     */
    private void detachPhysics() {
        StateManagerWrapper.getInstance().detachState(StateManagerWrapper.getInstance().getActiveState(BulletAppState.class));
    }

    /**
     * Set the color of the sky.
     */
    private void setSkyColor() {
        Color temp = level.getSkyColor();
        ColorRGBA tempColor = new ColorRGBA((float) temp.getRed() / 255, (float) temp.getGreen() / 255, (float) temp.getBlue() / 255, (float) temp.getAlpha() / 255);
        app.getViewPort().setBackgroundColor(tempColor);
    }
}
