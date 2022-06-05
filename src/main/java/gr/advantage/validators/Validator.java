package gr.advantage.validators;

import gr.advantage.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isDriverNameValid(String name) {
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public static boolean isLicensePlateUnique(ArrayList<Vehicle> vehicles, Vehicle vehicle) {
        if (vehicle.getNumberPlate().isEmpty() || vehicle.getNumberPlate().equals("")) {
            return false;
        }
        for (Vehicle v : vehicles) {
            if (v.getNumberPlate().equals(vehicle.getNumberPlate())) {
                return false;
            }
        }
        return true;
    }
}
