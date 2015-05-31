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

/**
 * The game appstate is the state in which the game itself is run and initialized. 
 * @author Anton
 */
public class GameAppState extends AbstractAppState implements IKeyListener {
    private Node rootNode;
    private Application app;
    private int levelToStart;
    private Level level;
    private Node levelNode;
    private GameHud hud;
    private boolean isPaused;
    private final Actions[] actions = new Actions[] {
        Actions.OPEN_MENU
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
    public GameAppState(int firstLevelToStart){
        setLevelToStart(firstLevelToStart);
        hud = new GameHud();
        NiftyGUIWrapper.getInstance().addScreen(hud.getScreenName(), hud.getScreen());
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        rootNode = ((SimpleApplication)app).getRootNode();
        this.app = app;
        InputManagerWrapper.getInstance().registerListener(this);
    }
    
    @Override
    public void cleanup() {
        super.cleanup();
        stopMusic();
        rootNode.detachAllChildren();
    }
    
    private void stopMusic() {
        for (Spatial node: (levelNode.getChildren())){
            if (node instanceof AudioNode){
                ((AudioNode)node).stop();
            }
        }
    }
        
    /**
     * Updates the the next level that should start.
     * @param levelno the number of the next level
     */
    public void setLevelToStart(int levelno) {
        levelToStart = levelno;
        level = LevelManager.getInstance().getLevel(levelToStart);
    }

    /**
     * Starts the level specified by setLevelToStart.
     */
    public void startLevel() {
        //Create a new hud and display it.
        app.getViewPort().setBackgroundColor(ColorRGBA.Cyan);
        NiftyGUIWrapper.getInstance().goToScreen(hud.getScreenName());
        levelNode = NodeFactory.createLevelNode(level, app.getCamera());
        rootNode.attachChild(levelNode);
    }

    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.equals(Actions.OPEN_MENU.toString()) && isPressed){
            pause();       
        }
    }
    
    public void pause(){
       StateManagerWrapper sm = StateManagerWrapper.getInstance();
        if (isPaused) {
            GameHudController.turnOpaque();
            isPaused = false;
            setEnabled(true);
            sm.enableState(sm.getAvailableState(BulletAppState.class));
        } else {
            GameHudController.turnGray();
            isPaused = true;
            setEnabled(false);
            sm.disableState(sm.getAvailableState(BulletAppState.class));
        }
    }

    @Override
    public Actions[] getKeyBinds() {
        return (Actions[])actions.clone();
    }
}
