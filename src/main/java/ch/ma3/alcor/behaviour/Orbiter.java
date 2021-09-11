package ch.ma3.alcor.behaviour;


import java.util.LinkedList;

import static ch.ma3.alcor.behaviour.CameraDirection.*;

public class Orbiter {

    public static final int DISTANCE_TO_MARS = 395;
    private int distance;

    private CameraDirection cameraDirection;

    private final LinkedList<CameraDirection> records = new LinkedList<>();

    public Orbiter(){
        cameraDirection = EARTH;
    }

    public CameraDirection getCameraDirection() {
        return cameraDirection;
    }

    public void updateDistance(int newDistance) {
        distance = newDistance;
        if (distance > (DISTANCE_TO_MARS / 2)) {
            cameraDirection = MARS;
        } else {
            cameraDirection = EARTH;
        }
        record();
    }

    public CameraDirection getAntennaDirection() {
        return MARS;
    }

    public void record() {
        records.add(cameraDirection);
    }

    public CameraDirection[] getRecord() {
        return records.toArray(new CameraDirection[]{});
    }
}
