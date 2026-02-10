import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Vehicle> {

    private int max;
    private List<T> vehicles = new ArrayList<>();

    public void load(T vehicle){
        if (vehicles.size() < max) {
            vehicles.add(vehicle);
        }
    }

    public T unload(T vehicle) {
        if (vehicles.isEmpty()) return null;
        if (vehicles.contains(vehicle)) {
            return vehicles.remove(vehicles.indexOf(vehicle));
        } else {
           return null;
        }
    }

}

