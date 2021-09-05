package ch.ma3.alcor.behaviour;

import org.junit.jupiter.api.Test;

import static ch.ma3.alcor.behaviour.CameraAngle.BACKWARD;
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
     * The Orbiter should turn its antenna towards Earth at a distance of 10km from earth and keep it oriented that way
     * <p>
     * The Orbiter should turn its camera towards Earth and after 20000km towards Mars
     * <p>
     * The antenna and camera can point in the same direction
     * The camera can only record if the antenna faces a planet
     * The camera can only record 10km worth of flight and when it's full it has to transmit
     * The antenna should transmit if it's facing earth if the camera has recorded something
     * with 100mW
     * and after 20 km with 200mW
     * <p>
     * <p>
     * The navigationsystem will tell the orbiter current time and distance from the planets.
     * <p>
     * [         ]
     * o          BACKWARD [ Orbiter ]  FORWARD         O
     * Earth               [         ]                  Mars
     */

    @Test
    void startWithCameraBackward() {
        Orbiter orbiter = new Orbiter();

        CameraAngle cameraAngle = orbiter.getCameraAngle();

        assertThat(cameraAngle, equalTo(BACKWARD));
    }


}
