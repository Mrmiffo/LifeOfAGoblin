package edu.chl.LifeOfAGoblin.jME3.utils;

import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.audio.AudioNode;
import com.jme3.scene.Spatial;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Anton
 */
public class Resources {
    private static Resources instance;
    private Map<String, Spatial> geometries = new HashMap<>();
    private String defaultPath;
    private AssetManager assetManager;
    

    
    private Resources(){
        defaultPath = "src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" + File.separator + "chl" + File.separator + "LifeOfAGoblin" + File.separator + "assets";
    }

    public static synchronized Resources getInstance(){
        if (instance == null){
            instance = new Resources();
        }
        return instance;
    }
    
    public void initialize(AssetManager assetManager){
        this.assetManager = assetManager;
    }
    
    private void addResource(String name, Spatial resource){
        geometries.put(name, resource.clone());
    }
    
    public void loadResource(String name, String folder){
        assetManager.registerLocator(defaultPath + File.separator + folder, FileLocator.class);
        addResource(name, assetManager.loadModel(name));
    }
    
    public Spatial getResources(String name){
        return geometries.get(name).clone();
    }
    
    public void setTempPath(String path){
        assetManager.registerLocator(defaultPath + File.separator + path, FileLocator.class);
    }
    
    public void loadSoundResource(String name, String folder){
        assetManager.registerLocator(defaultPath + File.separator + folder, FileLocator.class);
        addResource(name, new AudioNode(assetManager, name));
    }
}
