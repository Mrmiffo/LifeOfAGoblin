package edu.chl.LifeOfAGoblin.jME3.utils;

import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.audio.AudioNode;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.utils.SaveLoadManager;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The resources class loads and manages all the resources in the game. 
 * All j3o files are loaded into the game when Resources is initialized. 
 * Images and fonts used by NiftyGUI are loaded when needed by nifty methods 
 * using the setTempPath method in Resources.
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
//        loadImages();
        loadModels();
        loadScenes();
        loadSounds();
//        loadTextures();
    }
    
    private void addResource(String name, Spatial resource){
        geometries.put(name, resource.clone());
    }
    
    private void loadResources(List<String> files, String path){
        assetManager.registerLocator(path, FileLocator.class);
        for (String name: files){
            if (name.substring(name.length()-4, name.length()).equals(".j3o")){
                addResource(name, assetManager.loadModel(name));
            }
        }
    }
    
    public Spatial getResources(String name){
        return geometries.get(name).clone();
    }
    
    public void setTempPath(String folder){
        assetManager.registerLocator(defaultPath + File.separator + folder, FileLocator.class);
    }
    
    private void loadSoundResources(List<String> files, String path){
        assetManager.registerLocator(path, FileLocator.class);
        for (String name:files){
            addResource(name, new AudioNode(assetManager, name));
        }
    }

//    private void loadImages() {
//        String imagePath = defaultPath + File.separator + "images";
//        List<String> images = SaveLoadManager.getInstance().getSavedFiles(imagePath);
//        loadResources(images, imagePath);
//    }

    private void loadModels() {
        String modelPath = defaultPath + File.separator + "models";
        List<String> models = SaveLoadManager.getInstance().getSavedFiles(modelPath);
        loadResources(models, modelPath);
    }

    //Loads the scenes files. Textures in the scenes folder do not have to be loaded into the geometries.
    private void loadScenes() {
        String scenesPath = defaultPath + File.separator + "scenes";
        List<String> scenes = SaveLoadManager.getInstance().getSavedFiles(scenesPath);
        loadResources(scenes, scenesPath);
    }

    private void loadSounds() {
        String soundsPath = defaultPath + File.separator + "sounds";
        List<String> sounds = SaveLoadManager.getInstance().getSavedFiles(soundsPath);
        loadSoundResources(sounds, soundsPath);
    }

//    private void loadTextures() {
//        String texturesPath = defaultPath + File.separator + "textures";
//        List<String> textures = SaveLoadManager.getInstance().getSavedFiles(texturesPath);
//        loadSoundResources(textures, texturesPath);
//    }
}
