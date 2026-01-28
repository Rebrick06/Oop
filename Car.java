import java.awt.*;

// klassen kanse borde vara abstrakt ?? 
public abstract class Car implements Moveable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    public String modelName; // The car model name

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    protected abstract double speedFactor();

    private  void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    @Override
    public void move() {
        getCurrentSpeed();
    }

    @Override
    public void turnLeft() {
        
    }

    @Override
    public void turnRight() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

    
}
