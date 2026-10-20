class NeedForSpeed {
    private int speed = 0;
    private int batteryDrain = 0;
    private int distanceDriven = 0;
    private int battery = 100;
    
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        distanceDriven += speed;
        battery -= batteryDrain;
    }

    public int getBattery() {
        return battery;
    }

    public static void main() {
        
    }
}