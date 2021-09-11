package ch.ma3.alcor.behaviour;


import java.util.LinkedList;

import static ch.ma3.alcor.behaviour.Device.*;
import static ch.ma3.alcor.behaviour.Device.ANTENNA;
import static ch.ma3.alcor.behaviour.Direction.*;

public class Orbiter {

    public static final int DISTANCE_TO_MARS = 395;
    private Device directionEarthSlot;
    private int distance;

    private Direction cameraDirection;

    private final LinkedList<Direction> records = new LinkedList<>();

    public Orbiter() {
        directionEarthSlot = CAMERA;
    }

    public void updateDistance(int newDistance) {
        distance = newDistance;
        if (distance > (DISTANCE_TO_MARS / 2)) {
            cameraDirection = MARS;
            directionEarthSlot = ANTENNA;
        } else {
            cameraDirection = EARTH;
        }
        record();
    }


    public void record() {
        records.add(cameraDirection);
    }

    public Direction[] getRecord() {
        return records.toArray(new Direction[]{});
    }

    public boolean canTransmitVideo() {
        return directionEarthSlot == ANTENNA;
    }
}
