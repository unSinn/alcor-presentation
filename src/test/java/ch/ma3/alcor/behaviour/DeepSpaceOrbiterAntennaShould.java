package ch.ma3.alcor.behaviour;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DeepSpaceOrbiterAntennaShould {

    /**
     * 2D Space for simplicity
     * <p>
     * Swiss Space Force launches an Orbiter towards Mars
     * <p>
     * The Orbiter starts with its camera point to 0° and its antenna to 180°
     * <p>
     * The Orbiter should turn its antenna towards Earth at a distance of 10km from earth and keep it oriented that way
     * <p>
     * The Orbiter should turn its camera towards Mars of 1000km from Mars and keep it oriented that way
     * <p>
     * The antenna and camera can not face the same direction (should always keep +-10 degrees)
     * The camera can only record if the antenna faces a planet     *
     * The antenna should transmit if it's facing earth if the camera has recorded something
     * with 100mW
     * and after 20 km with 200mW
     * <p>
     * <p>
     * The navigationsystem will tell the orbiter current time and distance from the planets.
     */

    @Test
    void startWithCameraAt0() {
        Orbiter orbiter = new Orbiter();

        float cameraAngle = orbiter.getCameraAngle();

        assertThat(cameraAngle, equalTo(180f));
    }
}
