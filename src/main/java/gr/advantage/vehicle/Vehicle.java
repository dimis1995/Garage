package gr.advantage.vehicle;

public interface Vehicle {

    void startTimer();
    int getTimeParkedInMinutes();
    int getChargePerMinute();
    String getDriver();
    String getStaffDriver();
    void setStaffDriver(String staffDriver);
    String getNumberPlate();

    default double getMoney() {
        return getChargePerMinute() * getTimeParkedInMinutes();
    }
}

