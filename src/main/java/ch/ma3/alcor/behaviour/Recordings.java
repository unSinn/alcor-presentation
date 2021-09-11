package ch.ma3.alcor.behaviour;

import java.util.LinkedList;

public class Recordings {

    private final LinkedList<Direction> records = new LinkedList<>();

    public boolean isFull() {
        return records.size() == 2;
    }

    public void add(Direction cameraDirection) {
        records.add(cameraDirection);
    }

    public Direction[] getRecords() {
        return records.toArray(new Direction[]{});
    }
}
