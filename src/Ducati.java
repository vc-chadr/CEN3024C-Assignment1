public class Ducati extends Vehicle {

    public Ducati(String name, Race race) {
        super(name, "Ducati GP18", 360.0f, race);
    }

    @Override
    public float accelerate() {
        if (speed < 80.0f) {
            return 40.0f;
        } else if (speed < 155.0f) {
            return 37.5f;
        } else if (speed < 210.0f) {
            return 27.5f;
        } else if (speed < 260.0f) {
            return 25.0f;
        } else if (speed < 300.0f) {
            return 20.0f;
        } else if (speed < 320.0f) {
            return 10.0f;
        } else {
            return 5.0f;
        }
    }

}
