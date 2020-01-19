public class Focus extends Vehicle  {

    public Focus(String name, Race race) {
        super(name, "Focus RS", 268.0f, race);
    }

    @Override
    public float accelerate() {
        if (speed < 40.0f) {
            return 28.5f;
        } else if (speed < 60.0f) {
            return 25.0f;
        } else if (speed < 100.0f) {
            return 20.0f;
        } else if (speed < 120.0f) {
            return 17.5f;
        } else if (speed < 140.0f) {
            return 16.0f;
        } else if (speed < 160.0f) {
            return 13.5f;
        } else if (speed < 180.0f) {
            return 12.1f;
        } else {
            return 10.4f;
        }
    }

}
