package com.gluonapplicationDesktopMultipleViews.controllers;

import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;

import javax.inject.Inject;
import java.util.ResourceBundle;

public class HODLoginController {

    @Inject
    ParticleApplication app;

    @Inject private ViewManager viewManager;

    @FXML
    private Button button;

    @FXML
    private ResourceBundle resources;

    private Action actionHome;

    public void initialize() {
        ActionMap.register(this);
        actionHome =  ActionMap.action("goHome");

    }

    public void postInit() {
        app.getParticle().getToolBarActions().add(0, actionHome);
    }

    public void dispose() {
        app.getParticle().getToolBarActions().remove(actionHome);
    }

    @ActionProxy(text = "Back")
    private void goHome() {
        viewManager.switchView("primary");
    }
}
