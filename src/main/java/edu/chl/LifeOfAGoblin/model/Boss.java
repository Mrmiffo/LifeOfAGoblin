/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractHostileNPC;

/**
 *
 * @author Anton
 */
public class Boss extends AbstractHostileNPC {
    public Boss(String model){
        super(model);
        character.setUserData("objectType", "Boss");
    }
}
