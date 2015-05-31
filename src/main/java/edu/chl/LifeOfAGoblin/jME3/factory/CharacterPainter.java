/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.jME3.controller.character.AbstractMoveControl;
import edu.chl.LifeOfAGoblin.jME3.controller.ModelControl;
import edu.chl.LifeOfAGoblin.jME3.controller.character.NPCCollisionControl;
import edu.chl.LifeOfAGoblin.jME3.controller.character.NPCMoveControl;
import edu.chl.LifeOfAGoblin.jME3.controller.character.PlayerHealthControl;
import edu.chl.LifeOfAGoblin.jME3.controller.character.PlayerMoveControl;
import edu.chl.LifeOfAGoblin.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.utils.Resources;
import edu.chl.LifeOfAGoblin.model.character.Player;
import edu.chl.LifeOfAGoblin.model.character.Weapon;
import edu.chl.LifeOfAGoblin.model.character.AbstractCharacter;
import edu.chl.LifeOfAGoblin.model.character.AbstractNPC;

/**
 * The character factory is used to create and decorate player and NPC character
 * nodes.
 *
 * @author kakan
 */
class CharacterPainter {

    /**
     * Paints a node representing any character.
     *
     * @param node the node which will represent the character
     * @param character the character which the node will represent.
     * @return a node representing the character.
     */
    static void createCharacter(Node node, AbstractCharacter character) {
        //Connects the model to the node
        node.addControl(new ModelControl(character));

        makeSolid(node);
        makeMoveable(node);
        if (character.getClass() == Player.class) {
            paintPlayer(node);
        }
        if (character instanceof AbstractNPC) {
            paintNPC(node, (AbstractNPC) character);
        }
        provideGraphicalRepresentation(node);
    }

    /**
     * Adds player specific controls to the node
     *
     * @param node the node
     */
    static void paintPlayer(Node node) {
        //A control which use the player model data to update the game hud health bar.
        node.addControl(new PlayerHealthControl());
    }

    /**
     * Adds NPC specific controls to the node
     *
     * @param node the node
     * @param npc the model of the NPC
     */
    static void paintNPC(Node node, AbstractNPC npc) {
        enableReaction(node); //Adds AI
        addWeapon(node, npc);
    }

    /**
     * Makes any node solid provided it has a ModelControl.
     *
     * @param node the node to make solid.
     */
    private static void makeSolid(Node node) {
        CapsuleCollisionShape shape = createModelShape(node);
        BoxCollisionShape ghostShape = createGhostShape(node);
        attachCharacterControl(node, shape);
        attachGhostControl(node, ghostShape);
    }

    /**
     * Creates a shape after the template of a node.
     *
     * @param node the template for the shape.
     * @return the shape created of the template.
     */
    private static CapsuleCollisionShape createModelShape(Node node) {
        AbstractCharacter model = (AbstractCharacter) node.getControl(ModelControl.class).getModel();
        return new CapsuleCollisionShape(model.getWidth(), model.getHeight(), 1);
    }

    /**
     * Creates a shape after the template of a node.
     *
     * @param node the template for the shape.
     * @return the shape created of the template.
     */
    private static BoxCollisionShape createGhostShape(Node node) {
        AbstractCharacter model = (AbstractCharacter) node.getControl(ModelControl.class).getModel();
        return new BoxCollisionShape(new Vector3f(1, model.getCollisionHeight(), model.getCollisionWidth()));
    }

    /**
     * Attaches a CharacterControl to a node.
     *
     * @param node the node to attach the CharacterControl to.
     * @param shape the template for the shape of the CharacterControl.
     */
    private static void attachCharacterControl(Node node, CapsuleCollisionShape shape) {
        AbstractCharacter character = (AbstractCharacter) node.getControl(ModelControl.class).getModel();
        //NOTE: CharacterControl has been depricated prematurly due to BetterCharacterControl. Although BetterCharacterControl contains major flaws (such as missing step height) that make CharacterControl a better choice for this project.
        CharacterControl mover = new CharacterControl(shape, 0.05f);
        mover.setJumpSpeed(character.getJumpStrength());
        PhysicsWrapper.getInstance().addControl(mover);
        node.addControl(mover);
    }

    /**
     * Attaches a GhostControl to the node.
     *
     * @param node the node to attach the GhostControl to.
     * @param shape the template for the shape of the GhostControl.
     */
    private static void attachGhostControl(Node node, BoxCollisionShape shape) {
        GhostControl ghost = new GhostControl(shape);
        PhysicsWrapper.getInstance().addControl(ghost);

        //Attaching ghost control
        node.addControl(ghost);
    }

    /**
     * Adds what the character requires to move
     *
     * @param node the node to make moveable.
     */
    private static void makeMoveable(Node node) {
        AbstractCharacter model = (AbstractCharacter) node.getControl(ModelControl.class).getModel();
        AbstractMoveControl amc = null;
        if (model instanceof Player) {
            amc = new PlayerMoveControl();
            InputManagerWrapper.getInstance().registerListener((PlayerMoveControl) amc);
        } else if (model instanceof AbstractNPC) {
            amc = new NPCMoveControl();
        }

        if (amc != null) {
            //Attaching move control
            node.addControl(amc);
        }

    }

    /**
     * Provides the node with a graphical representation.
     *
     * @param node the node to be given a graphical representation.
     */
    private static void provideGraphicalRepresentation(Node node) {
        AbstractCharacter model = (AbstractCharacter) node.getControl(ModelControl.class).getModel();
        Spatial appearance = Resources.getInstance().getResources(model.getModelName());
        node.attachChild(appearance);
        //Moving the appearnace slightly to fit the CollisionShape
        appearance.setLocalTranslation(new Vector3f(0, -model.getHeight(), 0));
    }

    /**
     * Adds a control that checks for collisions.
     */
    private static void enableReaction(Node node) {
        NPCCollisionControl ncc = new NPCCollisionControl();
        node.addControl(ncc);
    }

    private static void addWeapon(Node node, AbstractNPC npc) {
        Node weaponNode = new Node();
        Weapon weapon = npc.getWeapon();

        weaponNode.addControl(new ModelControl(weapon));
        
        BoxCollisionShape ghostShape = new BoxCollisionShape(new Vector3f(1,
                weapon.getCollisionHeight(), weapon.getCollisionWidth()));

        attachGhostControl(weaponNode, ghostShape);

        node.attachChild(weaponNode);
    }
}
