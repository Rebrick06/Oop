import java.awt.*;

// klassen kanse borde vara abstrakt ?? 
public abstract class Car implements Moveable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    public String modelName; // The car model 
    protected double y;
    protected double x;
    protected Direction direction;


    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.y = 0;
        this.x = 0;
        this.direction = Direction.NORTH;
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
        switch (direction) {
            case Direction.NORTH ->
                y += getCurrentSpeed();
            case Direction.SOUTH ->
                y -= getCurrentSpeed();
            case Direction.EAST ->
                x += getCurrentSpeed();
            case Direction.WEST ->
                x -= getCurrentSpeed();
        }
    }

    @Override
    public void turnLeft() {
        switch (direction) {
            case Direction.NORTH -> 
                direction = Direction.WEST;
            case Direction.WEST ->
                direction = Direction.SOUTH;
            case Direction.SOUTH ->
                direction = Direction.EAST;
            case Direction.EAST ->
                direction = Direction.NORTH;
        }
    }

    @Override
    public void turnRight() {
         switch (direction) {
            case Direction.NORTH ->
                direction = Direction.EAST;
            case Direction.EAST ->
                direction = Direction.SOUTH;
            case Direction.SOUTH ->
                direction = Direction.WEST;
            case Direction.WEST -> 
                direction = Direction.NORTH;
        }
    }
}

