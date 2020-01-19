public class Audi extends Vehicle  {

    public Audi(String name, Race race) {
        super(name, "Audi S4", 250.0f, race);
    }

    @Override
    public float accelerate() {
        if (speed < 40.0f) {
            return 26.6f;
        } else if (speed < 80.0f) {
            return 21.0f;
        } else if (speed < 100.0f) {
            return 20.0f;
        } else if (speed < 130.0f) {
            return 17.0f;
        } else if (speed < 160.0f) {
            return 14.0f;
        } else if (speed < 180.0f) {
            return 12.0f;
        } else {
            return 11.0f;
        }
    }

}
