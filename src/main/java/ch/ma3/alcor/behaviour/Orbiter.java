package ch.ma3.alcor.behaviour;

import static ch.ma3.alcor.behaviour.CameraDirection.*;

public class Orbiter {

    private int distance;

    public CameraDirection getCameraDirection() {
        if (distance > 395.04 / 2) {
            return MARS;
        }
        return EARTH;
    }

    public void updateDistance(int i) {
        distance = i;
    }

    public CameraDirection getAntennaDirection() {
        return null;
    }
}
