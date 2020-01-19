import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Race {

    //TODO - UML
    //TODO - cleanup ordering and make private what you can
    public String[] FinishPosition = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};

    private ArrayList<Thread> threads;
    private ArrayList<Vehicle> vehicles;
    private  ArrayList<Vehicle> winners;
    private long monitorUpdateInterval;     // monitor status update in milliseconds
    private int nextFinishPosition;
    private long raceStartTime;
    private float raceLength;               // Race length in meters


    public Race(float length) {
        monitorUpdateInterval = 1000;
        nextFinishPosition = 0;
        raceStartTime = 0;
        raceLength = length;
    }

    public synchronized int getFinishPosition() {
        return nextFinishPosition;
    }

    public float getRaceLength() {
        return raceLength;
    }

    public long getRaceStartTime() {
        return raceStartTime;
    }

    public synchronized int claimFinishPosition(Vehicle vehicle) {
        winners.add(vehicle);
        return nextFinishPosition++;
    }

    private void printVehiclePositions() {
        for (Vehicle v : vehicles) {
            System.out.printf("%8s  %-12s | ", v.getPosition(), v.getSpeed());
        }
        System.out.print("\n");
    }

    public void start() {
        threads = new ArrayList<Thread>();
        vehicles = new ArrayList<Vehicle>();
        winners = new ArrayList<Vehicle>();

        // Create the vehicles and add to threads

        vehicles.add(new Audi("Maki", this));
        vehicles.add(new BMW("Cissy",this));
        vehicles.add(new Ducati("Taylor", this));
        vehicles.add(new Focus("Chad",this));
        vehicles.add(new Honda("Blue",this));
        vehicles.add(new Tesla("Kelsey", this));

        for (Vehicle v : vehicles) {
            threads.add(new Thread(v));
        }

        System.out.printf("--- Race begins! (length: %.0f meters, update interval: %.1f seconds) ---\n", raceLength, (monitorUpdateInterval / 1000.0f));

        // Display vehicle headers
        for (Vehicle v : vehicles) {
            System.out.printf("%-22s | ", v.getMake() + ": " + v.getName());
        }
        System.out.print("\n");

        for (Vehicle v : vehicles) {
            System.out.printf("%8s  %-12s | ", "Position", "Speed");
        }
        System.out.print("\n");
        printVehiclePositions();

        // Start the engines
        raceStartTime = System.currentTimeMillis();
        for (Thread t : threads) {
            t.start();
        }

        // Main race monitor loop
        while (getFinishPosition() != vehicles.size()) {
            try {
                Thread.sleep(monitorUpdateInterval);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            printVehiclePositions();
        }

        // Make sure threads have finished
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // Display final results
        printVehiclePositions();
        float raceTime = (System.currentTimeMillis() - raceStartTime) / 1000.0f;
        System.out.printf("--- Race Ends (elapsed time: %.2f seconds) ---\n", raceTime);

        try {
            FileWriter resultsFile = new FileWriter("results.txt");
            resultsFile.write("Results for a " + raceLength + " meter race that lasted " + raceTime + " seconds.\n");
            for (int i = 0; i < winners.size(); i++) {
                String positionStr = FinishPosition[i] + " - " + winners.get(i);
                System.out.println(positionStr);
                resultsFile.write(positionStr + "\n");
            }
            resultsFile.close();
        } catch (IOException e) {
            System.out.println("ERROR: Unable to save results to file");
            e.printStackTrace();
        }
    }

}