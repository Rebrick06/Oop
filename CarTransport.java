import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck{
    private final int max;
    private boolean rampUp;
    private Stack<Vehicle> loaded = new Stack<>();

    public CarTransport(int max){
        super(2, Color.yellow, 200, "CarTransport");
        this.rampUp=true;
        this.max = max;
    }

    private boolean canLoad(Vehicle vehicle){
        if (rampUp) return true;
        else if (vehicle instanceof Truck) return true;
        else if (getCurrentSpeed() != 0) return true;
        else return false;
    }

    public void loadVehicle(Vehicle vehicle) {
        if (canLoad(vehicle)) return;
        else if (vehicle.x - this.x < 1 && vehicle.x - this.x > -1 && vehicle.y - this.y < 1 && vehicle.y - this.y > -1) return;
        else if (max > loaded.size()) return;

        loaded.push(vehicle);
        vehicle.x = this.x;
        vehicle.y = this.y;

    }

    public void unLoadVehicle(Vehicle vehicle) {
        if (canLoad(vehicle)) return;

        loaded.pop();
        vehicle.x = this.x + 1;
        vehicle.y = this.y + 1;

    }

    @Override
    public void move() {
        if (rampUp) {
            super.move();
            for (Vehicle vehicle : loaded) {
                vehicle.x = this.x;
                vehicle.y = this.y;
            }
        }
    }
}


