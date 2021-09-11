package ch.ma3.alcor.behaviour;


import static ch.ma3.alcor.behaviour.Device.ANTENNA;
import static ch.ma3.alcor.behaviour.Device.CAMERA;
import static ch.ma3.alcor.behaviour.Direction.EARTH;
import static ch.ma3.alcor.behaviour.Direction.MARS;

public class Orbiter {

    public static final int DISTANCE_TO_MARS = 395;
    private Device directionEarthSlot;

    private Direction cameraDirection;
    private final Recordings recordings;

    public Orbiter() {
        recordings = new Recordings();
        directionEarthSlot = CAMERA;
    }

    public void updateDistance(int distance) {
        if (distance > (DISTANCE_TO_MARS / 2)) {
            cameraDirection = MARS;
            directionEarthSlot = ANTENNA;
        } else {
            cameraDirection = EARTH;
        }
        record();
        if (recordings.isFull()) {
            directionEarthSlot = ANTENNA;
        }
    }


    private void record() {
        recordings.add(cameraDirection);
    }

    public Direction[] getRecord() {
        if (!canTransmitVideo())
            throw new IllegalStateException("Antenna faces the wrong way");
        return recordings.getRecords();
    }

    public boolean canTransmitVideo() {
        return directionEarthSlot == ANTENNA;
    }
}
