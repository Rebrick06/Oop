import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class TestVolvo240{

    private Volvo240 volvo240;

    @BeforeEach
    public void before() {

        volvo240 = new Volvo240();

    }

    @Test
    public void test_volvo_start() {
        volvo240.startEngine();
        assertTrue(0 < volvo240.getCurrentSpeed());
    }

    @Test
    public void test_volvo_right() {
        volvo240.startEngine();
        volvo240.turnRight();
        double x_before = volvo240.x;
        volvo240.move();
        assertTrue(x_before < volvo240.x);
    }

    @Test
    public void test_volvo_left() {
        volvo240.startEngine();
        volvo240.turnLeft();
        double x_before = volvo240.x;
        volvo240.move();
        assertTrue(x_before > volvo240.x);

    }

}