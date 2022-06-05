package gr.advantage.garage;

import gr.advantage.validators.Validator;
import gr.advantage.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Random;

public class Garage {

    private int maximumSpots;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<String> staff;

    public ArrayList<String> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<String> staff) {
        this.staff = staff;
    }

    public int getMaximumSpots() {
        return maximumSpots;
    }

    public Garage(int maximumSpots) {
        this.maximumSpots = maximumSpots;
        this.vehicles = new ArrayList<>();
        this.staff = new ArrayList<>();
    }

    public void setMaximumSpots(int maximumSpots) {
        this.maximumSpots = maximumSpots;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "maximumSpots=" + maximumSpots +
                ", vehicles=" + vehicles +
                ", staff=" + staff +
                '}';
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public boolean isFull() {
        return this.maximumSpots == this.vehicles.size();
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public int getAvailableSpots() {
        return this.maximumSpots - this.vehicles.size();
    }

    private String getRandomStaffDriver() {
        Random rn = new Random();
        return this.staff.get(rn.nextInt(this.staff.size()));
    }

    public void parkVehicle(Vehicle vehicle) {
        if (this.getAvailableSpots() <= 0) {
            System.out.println("Garage is full");
            return;
        }
        if (Validator.isDriverNameValid(vehicle.getDriver()) && Validator.isLicensePlateUnique(this.vehicles, vehicle)) {
            vehicle.setStaffDriver(this.getRandomStaffDriver());
            this.vehicles.add(vehicle);
            vehicle.startTimer();
        }
    }

    private boolean hasVehicleInsideTheGarage(String driver) {
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getDriver().equals(driver)) {
                return true;
            }
        }
        return false;
    }

    public double freeParkingSpot(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            System.out.println("Vehicle not in garage");
            return 0;
        }
        vehicles.remove(vehicle);
        double charge = vehicle.getMoney();
        if (hasVehicleInsideTheGarage(vehicle.getDriver())) {
            if (vehicle.getTimeParkedInMinutes() < 30) {
                return 0;
            }
            charge = 0.7 * charge;
        }
        return charge;
    }
}
