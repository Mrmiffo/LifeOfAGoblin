package edu.chl.LifeOfAGoblin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The save load manager is a class used for saving and loading objects to the 
 * harddrive. 
 * @author Anton
 */
public class SaveLoadManager {
    private static SaveLoadManager instance;
    private SaveLoadManager(){
        
    }
    
    public static synchronized SaveLoadManager getInstance(){
        if (instance == null){
            instance = new SaveLoadManager();
        }
        return instance;
    }
    /**
     * This method will save the specified object to a file at the specified path.
     * @param objectToSave The Serializable object to save.
     * @param path The path to save the object to. Will be set to default home directory/LifeOfAGoblin/savedFiles if left as null.
     */
    public void saveToFile(Serializable objectToSave, String path, String name) throws IOException{

            if (path == null){			
                    new File(System.getProperty("user.home") + File.separator +"LifeOfAGoblin" + File.separator + "savedFiles").mkdirs();
                    path = System.getProperty("user.home") + File.separator + "LifeOfAGoblin" + File.separator + "savedFiles";
            }
            
            try{

                    FileOutputStream fout = new FileOutputStream(path + File.separator + name);
                try (ObjectOutputStream oos = new ObjectOutputStream(fout)) {   
                    oos.writeObject(objectToSave);
                    fout.close();
                }
            }catch(IOException ex){
                throw new IOException("Unable to save file.");
            }
    }

    /**
     * Loads the specified file into a Serializable object.
     * @param path The path to the file to load
     * @return the loaded file, or if none was found, null.
     */
    public Serializable loadFile(String path, String name) throws ClassNotFoundException, IOException{
            if (path == null){
                    path = System.getProperty("user.home") + File.separator + "LifeOfAGoblin" + File.separator + "savedFiles";
            }
            try{
                FileInputStream fin = new FileInputStream(path + File.separator + name);
                Object toReturn;
                try (ObjectInputStream ois = new ObjectInputStream(fin)) {
                    toReturn = ois.readObject();
                    fin.close();
                }
                return (Serializable)toReturn;
            }catch(IOException ex){
                throw new IOException("Unable to load file.");
            }catch(ClassNotFoundException e){
                throw new ClassNotFoundException("Loaded file could not be converted to Serializeable.");
            }
    }

    /**
     * Returns a list of all the files names in the specified folder. Use the loadFile method to load the file object.
     * @param path the folder to search
     * @return a list of file names.
     */
    public List<String> getSavedFiles(String path){
        List<String> toReturn = new ArrayList<>();
        if (path == null){
                new File(System.getProperty("user.home") + File.separator + "LifeOfAGoblin" + File.separator + "savedFiles").mkdirs();
                path = System.getProperty("user.home") + File.separator + "LifeOfAGoblin" + File.separator + "savedFiles";
        }
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null){
            for (int i = 0; i < listOfFiles.length; i++) {
                        if (listOfFiles[i].isFile()) {
                                toReturn.add(listOfFiles[i].getName());
                        } 
            }
        }
        return toReturn;
    }

    /**
     * Delete the file on the harddrive.
     * @param path the path to the file. Will be set ass home director/LifeOfAGoblin/savedFiles if left empty.
     * @param name the name of the file to delete
     */
    public void deleteFile(String path, String name){	
        if (path == null){
                new File(System.getProperty("user.home") + File.separator + "LifeOfAGoblin" + File.separator + "savedFiles").mkdirs();
                path = System.getProperty("user.home") + File.separator + "LifeOfAGoblin" + File.separator + "savedFiles";
        }
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null){
            for (int i = 0; i < listOfFiles.length; i++) {
                        if (listOfFiles[i].getName().equals(name)){
                                listOfFiles[i].delete();
                        } 
            }
        }
    
    }//tar bort den specifika profilen
}
