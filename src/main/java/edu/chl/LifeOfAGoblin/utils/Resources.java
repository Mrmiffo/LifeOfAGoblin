/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.scene.Spatial;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Anton
 */
public class Resources {
    private static Resources instance;
    private Map<String, Spatial> geometries = new HashMap<>();
    
    private Resources(){
    }

    public static synchronized Resources getInstance(){
        if (instance == null){
            instance = new Resources();
        }
        return instance;
    }
    
    public void addResource(String name, Spatial resource){
        geometries.put(name, resource.clone());
    }
    
    public Spatial getResources(String name){
        return geometries.get(name).clone();
    }
}
