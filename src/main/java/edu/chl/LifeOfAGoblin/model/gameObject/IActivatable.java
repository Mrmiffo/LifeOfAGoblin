package edu.chl.LifeOfAGoblin.model.gameObject;

/**
 * A interface for activatable objects.
 * @author Ulrika
 */
public interface IActivatable {
    
    /**
     * Activates the object.
     */
    public void activate();
    
    /**
     * Inactivates the object.
     */
    public void inactivate();
    
    /**
     * Returns true if the object is activated, false otherwise.
     * @return if the object is activated
     */
    public boolean isActivated();

}
