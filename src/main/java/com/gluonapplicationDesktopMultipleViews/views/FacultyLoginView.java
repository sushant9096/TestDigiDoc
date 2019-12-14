package com.gluonapplicationDesktopMultipleViews.views;

import com.gluonapplicationDesktopMultipleViews.controllers.FacultyLoginController;
import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.gluonapplicationDesktopMultipleViews.controllers.HODLoginController;

@ParticleView(name = "facultyloginview")
public class FacultyLoginView extends FXMLView {

    public FacultyLoginView() {
        super(HODLoginView.class.getResource("facultyloginview.fxml"));
    }

    @Override
    public void start() {
        ((FacultyLoginController) getController()).postInit();
    }

    @Override
    public void stop() {
        ((FacultyLoginController) getController()).dispose();
    }

}
