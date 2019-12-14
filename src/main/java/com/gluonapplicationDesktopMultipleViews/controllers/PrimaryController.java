package com.gluonapplicationDesktopMultipleViews.controllers;

import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.state.StateManager;
import com.gluonhq.particle.view.ViewManager;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;

public class PrimaryController {

    @Inject ParticleApplication app;
    
    @Inject private ViewManager viewManager;

    @Inject private StateManager stateManager;
    
    private boolean first = true;
    
    @FXML
    private Label label;
    
    @FXML
    private ResourceBundle resources;
    
    private Action actionAdminLogin;
    private Action actionHODLogin;
    private Action actionFacultyLogin;
    
    public void initialize() {
        ActionMap.register(this);
        actionAdminLogin =  ActionMap.action("AdminLogin");

        ActionMap.register(this);
        actionHODLogin = ActionMap.action("HODLogin");

        ActionMap.register(this);
        actionFacultyLogin = ActionMap.action("FacultyLogin");
        
    }
    
    public void postInit() {
        if (first) {
            stateManager.setPersistenceMode(StateManager.PersistenceMode.USER);
            addUser(stateManager.getProperty("UserName").orElse("").toString());
            first = false;
        }
        app.getParticle().getToolBarActions().add(0, actionAdminLogin);
        app.getParticle().getToolBarActions().add(1, actionHODLogin);
        app.getParticle().getToolBarActions().add(2,actionFacultyLogin);
    }
    
    public void dispose() {
        app.getParticle().getToolBarActions().remove(actionAdminLogin);
        app.getParticle().getToolBarActions().remove(actionHODLogin);
        app.getParticle().getToolBarActions().remove(actionFacultyLogin);
    }
    
    public void addUser(String userName) {
        label.setText(resources.getString("label.text") + (userName.isEmpty() ? "" :  ", " + userName) + "!");
        stateManager.setProperty("UserName", userName);
    }

    @ActionProxy(text="Admin Login")
    private void AdminLogin() {
        viewManager.switchView("secondary");
    }

    @ActionProxy(text="HOD Login")
    private void HODLogin() {
        viewManager.switchView("hodloginview");
    }

    @ActionProxy(text="Faculty Login")
    private void FacultyLogin() {
        viewManager.switchView("facultyloginview");
    }
}