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
 * NOTICE: the jME3 assetManager is NOT thread safe and loading resources in multiple 
 * threads at the same time may cause issues.
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
    /**
     * The initialize method will setup the assetManager and load any needed j3o
     * resources.
     * @param assetManager the assetManager from the simpler application
     */
    public void initialize(AssetManager assetManager){
        this.assetManager = assetManager;
//        loadImages();
        loadModels();
        loadScenes();
        loadSounds();
//        loadTextures();
    }
    
    /**
     * Add a resource to list of loaded resources.
     * @param name the name of the resource. Will be used to identify the resource.
     * @param resource 
     */
    private void addResource(String name, Spatial resource){
        geometries.put(name, resource.clone());
    }
    
    /**
     * Loads the resource from a file into a jME3 spatial and adds it to the 
     * list of available resrouces.
     * @param files the file names of the files to load.
     * @param path the path where the files are located.
     */
    private void loadResources(List<String> files, String path){
        assetManager.registerLocator(path, FileLocator.class);
        for (String name: files){
            if (name.substring(name.length()-4, name.length()).equals(".j3o")){
                addResource(name, assetManager.loadModel(name));
            }
        }
    }
    
    /**
     * A method to get a resource file that is already loaded into the memory.
     * @param name the name of the resource to load.
     * @return the spatial of the resource file.
     */
    public Spatial getResources(String name){
        return geometries.get(name).clone();
    }
    
    /**
     * The setTempPath method is used by Nifty screens to load resources as nifty 
     * use internal methods involving the assetManager. This method changes the 
     * default path of the assetManager temporarly to fit that file path.
     * @param folder 
     */
    public void setTempPath(String folder){
        assetManager.registerLocator(defaultPath + File.separator + folder, FileLocator.class);
    }
    
    /**
     * The load sounds resource will load an audioNode instead of a normal node 
     * into the list of available resrouces.
     * @param files the file names to load.
     * @param path the path where the files are located.
     */
    private void loadSoundResources(List<String> files, String path){
        assetManager.registerLocator(path, FileLocator.class);
        for (String name:files){
            addResource(name, new AudioNode(assetManager, name));
        }
    }


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
