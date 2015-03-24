package edu.chl.LifeOfAGoblin;

import edu.chl.LifeOfAGoblin.controller.ProjectController;
import edu.chl.LifeOfAGoblin.model.Project;
import edu.chl.LifeOfAGoblin.view.ProjectView;
import com.jme3.app.SimpleApplication;


/*
  Application entry class (if using standard java and Swing)
*/
public class Main extends SimpleApplication {

	public static void main(String[] args) {
//		SwingUtilities.invokeLater(() -> {
                    final Project project = new Project();
                    final ProjectView projectView = new ProjectView(project);
                    
                    ProjectController.create(project, projectView);
                    projectView.setVisible(true);
//                });
	}

    @Override
    public void simpleInitApp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
