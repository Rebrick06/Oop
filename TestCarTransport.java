import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCarTransport {

    private CarTransport carTransport;
    private Volvo240 volvo240;
    private Saab95 saab95;

    @BeforeEach
    public void before() {
        carTransport = new CarTransport(1);
        volvo240 = new Volvo240();
        saab95 = new Saab95();
    }

    @Test
    public void down_if_move() {
        carTransport.startEngine();
        carTransport.gas(0.5);
        carTransport.setRampDown();
        assertTrue(carTransport.getRampUp());
    }

    @Test
    public void car_on_transport() {
        volvo240.startEngine();
        volvo240.gas(0.1);
        volvo240.brake(0.3);
        carTransport.setRampDown();
        carTransport.loadVehicle(volvo240);
        assertEquals(carTransport.x, volvo240.x);
        assertEquals(carTransport.y, volvo240.y);
    }

    @Test
    public void car_off_transport() {
        volvo240.startEngine();
        volvo240.gas(0.1);
        volvo240.brake(0.3);
        carTransport.setRampDown();
        carTransport.loadVehicle(volvo240);
        assertEquals(1, carTransport.getLoadedSize());
        carTransport.unLoadVehicle(volvo240);
        assertEquals(0, carTransport.getLoadedSize());
    }

    @Test
    public void more_than_max() {
        volvo240.startEngine();
        volvo240.gas(0.1);
        volvo240.brake(0.3);
        carTransport.setRampDown();
        carTransport.loadVehicle(volvo240);
        saab95.startEngine();
        saab95.gas(0.3);
        saab95.brake(0.3);
            carTransport.loadVehicle(saab95);
        assertEquals(1, carTransport.getLoadedSize());
    }

}
