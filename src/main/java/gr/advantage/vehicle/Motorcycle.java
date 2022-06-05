package gr.advantage.vehicle;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Motorcycle implements Vehicle {

    private String driver;
    private String staffDriver;
    private int timeParked;
    private Date dateParked;
    private final String numberPlate;

    public int getChargePerMinute() {
        return 5;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "driver='" + driver + '\'' +
                ", staffDriver='" + staffDriver + '\'' +
                ", timeParked=" + timeParked +
                ", dateParked=" + dateParked +
                ", numberPlate='" + numberPlate + '\'' +
                '}';
    }

    public Motorcycle(String driver, String numberPlate) {
        this.driver = driver;
        this.numberPlate = numberPlate;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getTimeParked() {
        return timeParked;
    }

    public void setTimeParked(int timeParked) {
        this.timeParked = timeParked;
    }

    @Override
    public void startTimer() {
        dateParked = new Date();
    }

    @Override
    public int getTimeParkedInMinutes() {
        Date dateNow = new Date();
        long diff = dateNow.getTime() - dateParked.getTime();
        return (int)TimeUnit.MILLISECONDS.toMinutes(diff);
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public String getStaffDriver() {
        return this.staffDriver;
    }

    @Override
    public void setStaffDriver(String staffDriver) {
        this.staffDriver = staffDriver;
    }

    @Override
    public String getNumberPlate() {
        return this.numberPlate;
    }
}
