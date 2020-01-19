public class BMW extends Vehicle  {

    public BMW(String name, Race race) {
        super(name, "BMW M5", 305.0f, race);
    }

    @Override
    public float accelerate() {
        if (speed < 40.0f) {
            return 38.4f;
        } else if (speed < 50.0f) {
            return 33.3f;
        } else if (speed < 60.0f) {
            return 32.2f;
        } else if (speed < 100.0f) {
            return 31.5f;
        } else if (speed < 130.0f) {
            return 26.5f;
        } else if (speed < 150.0f) {
            return 24.5f;
        } else if (speed < 160.0f) {
            return 23.5f;
        } else if (speed < 200.0f) {
            return 19.5f;
        } else if (speed < 250.0f) {
            return 14.1f;
        } else {
            return 10.0f;
        }
    }
}
