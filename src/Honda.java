public class Honda extends Vehicle  {

    public Honda(String name, Race race) {
        super(name, "Honda R", 270.0f, race);
    }

    @Override
    public float accelerate() {
        if (speed < 40.0f) {
            return 20.0f;
        } else if (speed < 80.0f) {
            return 18.5f;
        } else if (speed < 100.0f) {
            return 17.5f;
        } else if (speed < 120.0f) {
            return 15.1f;
        } else if (speed < 130.0f) {
            return 15.0f;
        } else if (speed < 140.0f) {
            return 14.0f;
        } else if (speed < 160.0f) {
            return 12.8f;
        } else if (speed < 180.0f) {
            return 11.5f;
        } else {
            return 10.0f;
        }
    }

}
