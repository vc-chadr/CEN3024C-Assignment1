public interface Drive {

    // accelerate returns the emulated accerleration values for a vehicle's current speed/gear/engine RPM.
    // return value is an increase to the vehicles current speed (kph) over 1 second
    public float accelerate();

}
