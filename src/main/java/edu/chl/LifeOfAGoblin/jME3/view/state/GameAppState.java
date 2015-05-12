package edu.chl.LifeOfAGoblin.jME3.view.state;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.model.Level;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeFactory;
import edu.chl.LifeOfAGoblin.model.Player;



/**
 *
 * @author Anton
 */
public class GameAppState extends AbstractAppState {
    private Node rootNode;
    private Application app;
    public GameAppState(){

    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        rootNode = ((SimpleApplication)app).getRootNode();
        this.app = app;
        loadResources();
        //Start level
        temporaryMethodToCreateLevel();
        app.getViewPort().setBackgroundColor(ColorRGBA.Cyan);
//        rootNode.attachChild(currentLevel.getScene());
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

    private void loadResources() {
        System.out.println("Loading resources...");
        loadSounds();
    }

    private void loadSounds() {
        System.out.println("Loading sounds...");
    }

    
    
    //EVERYTHING BELOW THIS POINT IS TO BE REMOVED!!! ONLY HERE UNTIL LEVEL AND INPUT MANAGER IS IMPLEMENTED
    private void temporaryMethodToCreateLevel() {
        Player newPlayer = new Player();
        Level level = new Level("Level1.j3o", newPlayer);
        rootNode.attachChild(NodeFactory.createModeledLevelNode(level, app.getCamera()));

        //Character physics test:
//        Material stone_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
////        TextureKey key2 = new TextureKey("Textures/Terrain/Rock/Rock.PNG");
////        key2.setGenerateMips(true);
////        Texture tex2 = assetManager.loadTexture(key2);
////        stone_mat.setTexture("ColorMap", tex2);
//        Box box = new Box(1f,1f,1f);
//        Geometry brick_geo = new Geometry("brick", box);
//        brick_geo.setMaterial(stone_mat);
//        /** Position the brick geometry  */
//        brick_geo.setLocalTranslation(new Vector3f(0f, 10f, 0));
//        /** Make brick physical with a mass > 0.0f. */
//        RigidBodyControl brick_phy = new RigidBodyControl(2f);
//        /** Add physical brick to physics space. */
//        brick_geo.addControl(brick_phy);
//        PhysicsWrapper.getInstance().add(brick_phy);
//        rootNode.attachChild(brick_geo);
//        //Character physics test completed.
    }
    
//    private void initKeys(PlayerMoveControl playerListener) {
//        KeyBindings.attachStartUpKeyBinds(app.getInputManager());
//        KeyManager km = KeyManager.getInstance();
//        km.addKeyControl("PlayerMoveControl", playerListener, "walkLeft", "walkRight", "jump");
////        Map<InputListener, String[]> stuff = km.getResources("PlayerMoveControl");
//        app.getInputManager().addListener(playerListener, "walkLeft", "walkRight", "jump");
//    }

}
