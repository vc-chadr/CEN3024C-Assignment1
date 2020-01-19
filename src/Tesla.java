public class Tesla extends Vehicle  {

    public Tesla(String name, Race race) {
        super(name, "Tesla 3", 261.0f, race);
    }

    @Override
    public float accelerate() {
        if (speed < 50.0f) {
            return 26.3f;
        } else if (speed < 80.0f) {
            return 27.5f;
        } else if (speed < 100.0f) {
            return 28.5f;
        } else if (speed < 120.0f) {
            return 23.0f;
        } else if (speed < 130.0f) {
            return 22.0f;
        } else if (speed < 140.0f) {
            return 20.5f;
        } else if (speed < 160.0f) {
            return 19.5f;
        } else if (speed < 180.0f) {
            return 15.3f;
        } else if (speed < 200.0f) {
            return 14.1f;
        } else {
            return 10.0f;
        }
    }

}


/*
extends Vehicle  {

    public Tesla(String name, Race race) {
        super(name, "Tesla S", 249.0f, race);
    }

    @Override
    public float accelerate() {
        if (speed < 40.0f) {
            return 40.0f;
        } else if (speed < 80.0f) {
            return 20.0f;
        } else if (speed < 120.0f) {
            return 10.0f;
        } else {
            return 5.0f;
        }
    }
 */