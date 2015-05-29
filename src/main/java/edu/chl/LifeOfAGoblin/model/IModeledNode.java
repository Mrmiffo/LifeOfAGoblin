package edu.chl.LifeOfAGoblin.model;

/**
 * The IModeldNode interface extends the INode interface and provides a method 
 * to return the name of the model. This name is passed to the jME3 engine to
 * load the resources from the harddrive and connect them to nodes.
 * @author Anton
 */
public interface IModeledNode extends INode {
    
    
    /**
     * Returns the name of the implementor's model.
     * @return the name of the model
     */
    public String getModelName();
}
