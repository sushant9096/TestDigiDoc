package com.gluonapplicationDesktopMultipleViews;

import com.gluonhq.particle.application.ParticleApplication;
import javafx.scene.Scene;
import static org.controlsfx.control.action.ActionMap.actions;

public class GluonApplication extends ParticleApplication {

    public GluonApplication() {
        super("Digital Doc");
    }

    @Override
    public void postInit(Scene scene) {
        scene.getStylesheets().add(GluonApplication.class.getResource("style.css").toExternalForm());

        setTitle("DigitalDoc");

        getParticle().buildMenu("Home -> [test]", "Help -> [about]", "Exit -> [exit]");
        
        getParticle().getToolBarActions().addAll(actions("---"));
    }
}