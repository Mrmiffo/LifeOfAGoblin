/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import java.util.ArrayList;

/**
 *
 * @author kakan
 */
public class LevelList {
    
    private static ArrayList<Level>listOfLevels = new ArrayList();
    
    /**
     * Adds the level to the last position in the list
     * @param level
     */
    public static void addLevel(Level level) {
        addLevel(level, listOfLevels.size()+1);
    }
    
    /**
     * Adds the level to the specified position in the list
     * @param level the level to be added
     * @param position the number the level will have in the list, where 1 is the first position
     */
    public static void addLevel(Level level, int position) {
        if (position < 1 || listOfLevels.size() < position) {
            throw new IndexOutOfBoundsException("In LevelList: addLevel().");
        }
        
        if (listOfLevels.contains(level)) {
            throw new IllegalArgumentException("In LevelList: addLevel(). Can't add already existing level");
        }
        
        listOfLevels.add(position-1, level);
    }
    
    public static void removeLevel(Level level) {
        if (!listOfLevels.remove(level)) {
            throw new IllegalArgumentException("In LevelList: removeLevel(Level level). No such level exists.");
        }
    }
    
    public static void removeLevel(int position) {
        if (position < 1 || listOfLevels.size() < position) {
            throw new IndexOutOfBoundsException("In LevelList: removeLevel(int position).");
        }
        listOfLevels.remove(position-1);
    }
    
    public static Level getNext(Level level) {
        if ((listOfLevels.indexOf(level) == -1) || (listOfLevels.indexOf(level) == listOfLevels.size()-1)) {
            throw new IllegalArgumentException("In LevelList: getNext(). ");
        }
        return listOfLevels.get(listOfLevels.indexOf(level) +1);
    }
    
    public static ArrayList<Level> getList() {
        return (ArrayList<Level>)listOfLevels.clone();
    }
    
    public static Level getLevel(int position) {
        if (position < 1 || listOfLevels.size() < position) {
            throw new IndexOutOfBoundsException("In LevelList: getLevel().");
        }
        return listOfLevels.get(position-1);
    }
    
    public static int getPosition(Level level) {
        return listOfLevels.indexOf(level)+1;
    }
}
