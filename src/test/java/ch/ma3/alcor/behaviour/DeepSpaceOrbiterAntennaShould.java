package ch.ma3.alcor.behaviour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ch.ma3.alcor.behaviour.Direction.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DeepSpaceOrbiterAntennaShould {


    /**
     * 2D Space for simplicity
     * <p>
     * Swiss Space Force launches an Orbiter towards Mars
     * <p>
     * The Orbiter starts with its camera point to BACKWARD and its antenna FORWARD
     * <p>
     * The antenna and camera can not point in the same direction
     * The camera can only record if the antenna faces a planet
     * Te camera should record the closest planet as long as possible
     * (thus the camera should record Earth and after half way record Mars)
     * The camera can  record 2x1 Mkm worth of flight and when it's full it has to transmit
     * (the camera recording can not be interrupted, it will always record 1M km worth of footage)
     * The antenna should try to transmit if it's facing earth if the camera has recorded something (and the camera is not recording)
     * The camera should no longer record if it is full and should instead turn away for the antenna to transmit.
     * with 100mW
     * and after 20 km with 200mW
     * <p>
     * <p>
     * The navigationsystem will tell the orbiter current time and distance from the planets.
     * <p>
     * LEFT
     * [         ]
     * o          BACKWARD [ Orbiter ]  FORWARD         O
     * Earth               [         ]                  Mars
     * <p>
     * <---------------395.04 million km ------------->
     * <p>
     * For simplificaiton distance is equal to time: Every Mkm = 1h recording
     * The orbiter can always receive/communicate, the antenna is only required for transmitting "HD Video Recordings".
     */

    private Orbiter orbiter;

    @BeforeEach
    void setUp() {
        orbiter = new Orbiter();
    }

    @Test
    void recordEarthAfterLaunch() {
        orbiter.updateDistance(1);
        assertThat(orbiter.getRecord(), hasItemInArray(EARTH));
    }

    @Test
    void recordMarsAfterHalfway() {
        orbiter.updateDistance(390);
        assertThat(orbiter.getRecord(), hasItemInArray(MARS));
    }

    @Test
    void transmitTwoRecordsAfter2mkm() {
        orbiter.updateDistance(1);
        orbiter.updateDistance(2);
        assertThat(orbiter.getRecord(), is(new Direction[]{EARTH, EARTH}));
    }

    @Test
    void beUnableToTransmit_ifAntennaFacesTheWrongWay() {
        orbiter.updateDistance(1);
        assertThat(orbiter.canTransmitVideo(), is(false));
    }

}
