package edu.chl.LifeOfAGoblin.jME3.view.state;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.model.Level;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeFactory;

/**
 *
 * @author Anton
 */
public class GameAppState extends AbstractAppState {
    private Node rootNode;
    private Application app;
    private String levelToStart;
    
    /**
     * Creates a GameAppState with a default first level 
     */
    public GameAppState() {
        levelToStart = "Level1.j3o";
    }
    
    /**
     * Creates a GameAppState with a specified first level 
     */
    public GameAppState(String firstLevelToStart){
        levelToStart = firstLevelToStart;
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        rootNode = ((SimpleApplication)app).getRootNode();
        this.app = app;
        
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
     * Updates the name of the next level that should start.
     * @param levelName the name of the next level
     */
    public void updateLevelToStart(String levelName) {
        levelToStart = levelName;
    }

    /**
     * Starts the level specified by updateLevelToStart.
     */
    private void startLevel() {
        Level level = new Level(levelToStart);
        Node levelNode = NodeFactory.createModeledLevelNode(level, app.getCamera());
        rootNode.attachChild(levelNode);
    }
}
