public abstract class Vehicle implements Runnable, Drive {

    protected float speed;

    private int finishedPosition;
    private long lastFrameTime;
    private String make;
    private String name;
    private float position;
    private Race race;
    private float topSpeed;


    public Vehicle(String name, String make, float topSpeed, Race race) {
        this.make = make;
        this.name = name;
        this.topSpeed = topSpeed;
        this.race = race;

        speed = 0;
        position = 0;
        finishedPosition = -1;
        lastFrameTime = 0;
    }

    public String getMake() {
        return make;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        if (finishedPosition < 0) {
            return String.format("%.2f", position);
        } else {
            return race.FinishPosition[finishedPosition];
        }
    }

    public String getSpeed() {
        if (finishedPosition < 0) {
            return String.format("%.0f kph %s", speed, (speed == topSpeed ? "MAX" : ""));
        } else {
            return "place";
        }
    }

    public void run() {
        float deltaFrameTime;
        long timeNow;

        lastFrameTime = race.getRaceStartTime();

        while (finishedPosition < 0) {
            timeNow = System.currentTimeMillis();
            deltaFrameTime = (timeNow - lastFrameTime) / 1000.0f;
            lastFrameTime = timeNow;

            if (speed < topSpeed) {
                speed += ((Drive) this).accelerate() * deltaFrameTime;
                if (speed > topSpeed) {
                    speed = topSpeed;
                }
            }
            position += speed / 3.6;    // km/h to meters per second

            if (position >= race.getRaceLength()) {
                finishedPosition = race.claimFinishPosition(this);
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String toString() {
        return name + " driving a " + make;
    }

}

