package com.gluonapplicationDesktopMultipleViews.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.gluonapplicationDesktopMultipleViews.controllers.HODLoginController;

@ParticleView(name = "hodloginview")
public class HODLoginView extends FXMLView {

    public HODLoginView() {
        super(HODLoginView.class.getResource("hodloginview.fxml"));
    }

    @Override
    public void start() {
        ((HODLoginController) getController()).postInit();
    }

    @Override
    public void stop() {
        ((HODLoginController) getController()).dispose();
    }

}
