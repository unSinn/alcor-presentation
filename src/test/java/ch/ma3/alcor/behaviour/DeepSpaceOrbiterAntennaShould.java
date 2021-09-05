package ch.ma3.alcor.behaviour;

import org.junit.jupiter.api.Test;

import static ch.ma3.alcor.behaviour.CameraDirection.EARTH;
import static ch.ma3.alcor.behaviour.CameraDirection.MARS;
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
     * The antenna and camera can point in the same direction
     * The camera can only record if the antenna faces a planet
     * Te camera should record the closest planet as long as possible
     * (thus the camera should directly start recording after launch)
     * (thus the camera should record earth and after half way record mars)
     * The camera can  record 2x100km worth of flight and when it's full it has to transmit
     * (the camera recording can not be interrupted, it will alway record 100km worth of footage)
     * The camera should face the closest planet
     * The antenna should transmit if it's facing earth if the camera has recorded something
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
     */

    @Test
    void startWithCameraFacingEarth() {
        Orbiter orbiter = new Orbiter();

        CameraDirection cameraAngle = orbiter.getCameraDirection();

        assertThat(cameraAngle, equalTo(EARTH));
    }

    @Test
    void recordEarthUntilHalfway() {
        Orbiter orbiter = new Orbiter();

        orbiter.updateDistance(395);

        assertThat(orbiter.getCameraDirection(), equalTo(MARS));
    }


}
