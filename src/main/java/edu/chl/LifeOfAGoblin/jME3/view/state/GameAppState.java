package edu.chl.LifeOfAGoblin.jME3.view.state;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.jME3.controller.interfaces.IKeyListener;
import edu.chl.LifeOfAGoblin.model.Level;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeFactory;
import edu.chl.LifeOfAGoblin.jME3.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.GameHud;
import edu.chl.LifeOfAGoblin.model.Actions;
import edu.chl.LifeOfAGoblin.utils.LevelManager;

/**
 * The game appstate is the state in which the game itself is run and initialized. 
 * @author Anton
 */
public class GameAppState extends AbstractAppState implements IKeyListener {
    private Node rootNode;
    private Application app;
    private int levelToStart;
    private Level level;
    private GameHud hud;
    
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
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        rootNode = ((SimpleApplication)app).getRootNode();
        this.app = app;
        InputManagerWrapper.getInstance().registerListener(this);
        
        //Starts the level and sets the background
        startLevel();
        app.getViewPort().setBackgroundColor(ColorRGBA.Cyan);
    }
    
    @Override
    public void cleanup() {
        super.cleanup();

    }
    
    @Override
    public void setEnabled(boolean enabled) {
        
    }
    
    @Override
    public void update(float tpf) {
        
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
        NiftyGUIWrapper.getInstance().addScreen(hud.getScreenName(), hud.getScreen());
        NiftyGUIWrapper.getInstance().goToScreen(hud.getScreenName());
        Node levelNode = NodeFactory.createModeledLevelNode(level, app.getCamera());
        rootNode.attachChild(levelNode);
    }

    private final Actions[] actions = new Actions[] {
        Actions.OPEN_MENU
    };

    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.equals(Actions.OPEN_MENU.toString())){
                pause();       
        }
    }
    
    public void pause(){
        System.out.println("pause");
        StateManagerWrapper.getInstance().deactivateState(this);
        StateManagerWrapper.getInstance().activateState(PauseAppState.class);
    }

    @Override
    public Actions[] getKeyBinds() {
        return (Actions[])actions.clone();
    }
}
