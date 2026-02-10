import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSaab95 {

    private Saab95 saab95;

    @BeforeEach
    public void before() {

        saab95 = new Saab95();

    }

    @Test
    public void test_saab_start() {
        saab95.startEngine();
        assertTrue(0 < saab95.getCurrentSpeed());
    }

    @Test
    public void test_saab_right() {
        saab95.startEngine();
        saab95.turnRight();
        double x_before = saab95.x;
        saab95.move();
        assertTrue(x_before < saab95.x);
    }

    @Test
    public void test_saab_left() {
        saab95.startEngine();
        saab95.turnLeft();
        double x_before = saab95.x;
        saab95.move();
        assertTrue(x_before > saab95.x);
    }
}