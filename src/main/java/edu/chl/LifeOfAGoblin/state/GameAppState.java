package edu.chl.LifeOfAGoblin.state;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.model.Level;
import edu.chl.LifeOfAGoblin.utils.NodeFactory;
import edu.chl.LifeOfAGoblin.utils.Resources;
import java.io.File;


/**
 *
 * @author Anton
 */
public class GameAppState extends AbstractAppState {
    
    private String filePath;

    SimpleApplication app;
    AssetManager assetManager;
    ViewPort viewPort;
    Node rootNode;
    

    public GameAppState(){
        this.filePath = "src" + File.separator + "main" + File.separator + "java"
                + File.separator + "edu" + File.separator + "chl"+ File.separator
                + "LifeOfAGoblin";
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication)app;
        this.assetManager = app.getAssetManager();
        this.viewPort = ((SimpleApplication)app).getViewPort();
        this.rootNode = ((SimpleApplication)app).getRootNode();
        
        
        loadResources();
        //Start level
        temporaryMethodToCreateLevel();
//        Level currentLevel = new Level(levelToCreate);
        viewPort.setBackgroundColor(ColorRGBA.Cyan);
//        rootNode.attachChild(currentLevel.getScene());
    }
    
    @Override
    public void cleanup() {
        super.cleanup();
        this.app = null;
        this.assetManager = null;
        this.viewPort = null;
        this.rootNode = null;
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        
    }
    
    @Override
    public void update(float tpf) {
        
    }

    private void loadResources() {
        System.out.println("Loading resources...");
        loadModels();
        loadScenes();
        loadSounds();
    }
    
    private void loadModels() {
        System.out.println("Loading models...");
        assetManager.registerLocator(filePath + File.separator + "assets" + File.separator
                + "models", FileLocator.class);
        Resources.getInstance().addResource("Goblin", assetManager.loadModel("Goblin2.j3o"));
    }

    private void loadScenes() {
        System.out.println("Loading scenes...");
        assetManager.registerLocator(filePath + File.separator + "assets" + File.separator
                + "scenes", FileLocator.class);
        Resources.getInstance().addResource("TestScene", assetManager.loadModel("testScene.j3o"));
    }

    private void loadSounds() {
        System.out.println("Loading sounds...");
        assetManager.registerLocator("src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" + File.separator + "chl" + File.separator + "LifeOfAGoblin" + File.separator + "assets" + File.separator + "sounds", FileLocator.class);     
    }

    
    
    //EVERYTHING BELOW THIS POINT IS TO BE REMOVED!!! ONLY HERE UNTIL LEVEL AND INPUT MANAGER IS IMPLEMENTED
    private void temporaryMethodToCreateLevel() {
        Level level = new Level("TestScene");
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
