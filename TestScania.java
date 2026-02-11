import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestScania {

    private Scania scania;

    @BeforeEach
    public void before() {
        scania = new Scania();
    }

    @Test
    public void test_scania_raise() {
        scania.raisePlatform(50);
        scania.raisePlatform(40);
        assertEquals(70, scania.getPlatformAngle());
    }

    @Test
    public void test_scania_lower() {
        scania.lowerPlatform(80);
        assertEquals(0, scania.getPlatformAngle());
    }

    @Test
    public void test_scania_drive() {
        scania.raisePlatform(30);
        scania.startEngine();
        scania.gas(0.9);
        assertEquals(0, scania.x);
        assertEquals(0, scania.y);

    }
}
