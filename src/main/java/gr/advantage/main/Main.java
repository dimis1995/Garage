package gr.advantage.main;

import gr.advantage.garage.Garage;
import gr.advantage.vehicle.Car;
import gr.advantage.vehicle.Motorcycle;
import gr.advantage.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// You can use this to test out the Garage functionality
public class Main {

    public static void main(String[] args) {

        Garage garage = new Garage(5);
        garage.setStaff(new ArrayList<>(Arrays.asList("staff1", "staff2", "staff3", "staff4")));

        Car car1 = new Car("LeoMaoTheThird", "58008");
        Car car2 = new Car("LeoMaoTheThird", "12345");

        Motorcycle motorcycle1 = new Motorcycle("KapetanOdysseas", "123654");
        Motorcycle motorcycle2 = new Motorcycle("Bariemai", "987654");

        Car car3 = new Car("oxiallaonomata", "654789");

        garage.parkVehicle(car1);
        garage.parkVehicle(car2);
        garage.parkVehicle(car3);
        garage.parkVehicle(motorcycle1);
        garage.parkVehicle(motorcycle2);

        System.out.println(garage);

        while(true) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter Something");
            String userInput = myObj.nextLine();
            if (userInput.equals("Exit")) {
                return;
            }
            System.out.println(userInput);
            if (userInput.equals("1")) {
                if (garage.isFull()) {
                    System.out.println(garage.freeParkingSpot(car3));
                } else {
                    garage.parkVehicle(car3);
                    System.out.println("car parked");
                }
            }
        }
    }
}
