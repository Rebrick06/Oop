import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class carTest {

    private Volvo240 volvo240;

    @BeforeEach
    public void before() {

        volvo240 = new Volvo240();

    }

    @Test
    public void gas_test() {
        volvo240.startEngine();
        double before_speed = volvo240.getCurrentSpeed();
        volvo240.gas(0.9);
        assertTrue(before_speed < volvo240.getCurrentSpeed() && 0 < volvo240.getCurrentSpeed());

    }

    @Test
    public void brake_test() {
        volvo240.startEngine();
        volvo240.gas(0.9);
        double speed_after_gas = volvo240.getCurrentSpeed();
        volvo240.brake(0.3);
        assertTrue(speed_after_gas > volvo240.getCurrentSpeed());

    }

    @Test
    public void gas_test_if_decrease() {
        volvo240.startEngine();
        volvo240.gas(0.9);
        double speed_after_gas = volvo240.getCurrentSpeed();
        volvo240.gas(0.9);
        assertTrue(speed_after_gas < volvo240.getCurrentSpeed());
        }



    @Test
    public void brake_test_if_increase() {
        volvo240.startEngine();
        volvo240.gas(0.9);
        volvo240.brake(0.4);
        double speed_before_last_brake = volvo240.getCurrentSpeed();
        volvo240.brake(0.5);
        assertTrue(speed_before_last_brake > volvo240.getCurrentSpeed());
        }

    }




