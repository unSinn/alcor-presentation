package ch.ma3.alcor.behaviour;


import java.util.LinkedList;

import static ch.ma3.alcor.behaviour.Direction.*;

public class Orbiter {

    public static final int DISTANCE_TO_MARS = 395;
    private int distance;

    private Direction cameraDirection;
    private Direction antennaDirection;


    private final LinkedList<Direction> records = new LinkedList<>();

    public Orbiter() {
        cameraDirection = EARTH;
    }

    public Direction getCameraDirection() {
        return cameraDirection;
    }

    public Direction getAntennaDirection() {
        return MARS;
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


    public void record() {
        records.add(cameraDirection);
    }

    public Direction[] getRecord() {
        return records.toArray(new Direction[]{});
    }

    public boolean canTransmitVideo() {
        return antennaDirection == EARTH;
    }
}
