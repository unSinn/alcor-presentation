package ch.ma3.alcor.behaviour;

import static ch.ma3.alcor.behaviour.CameraDirection.*;

public class Orbiter {

    public CameraDirection getCameraDirection() {
        return BACKWARD;
    }

    public boolean isRecording() {
        return true;
    }
}
