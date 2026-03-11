package ui;

import api.HotelResource;
import model.IRoom;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    private static final HotelResource hotelResource = HotelResource.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        boolean running = true;

        while (running) {

            System.out.println("\nMain Menu");
            System.out.println("1. Find and reserve a room");
            System.out.println("2. See my reservations");
            System.out.println("3. Create an account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    findAndReserveRoom();
                    break;

                case "2":
                    seeReservations();
                    break;

                case "3":
                    createAccount();
                    break;

                case "4":
                    AdminMenu.start();
                    break;

                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void createAccount() {

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();

        hotelResource.createACustomer(email, firstName, lastName);

        System.out.println("Account created successfully!");
    }

    private static void seeReservations() {

        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        Collection<Reservation> reservations =
                hotelResource.getCustomersReservations(email);

        if (reservations == null || reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            reservations.forEach(System.out::println);
        }
    }

    private static void findAndReserveRoom() {

        try {

            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

            System.out.println("Enter Check-in Date (MM/dd/yyyy):");
            Date checkIn = format.parse(scanner.nextLine());

            System.out.println("Enter Check-out Date (MM/dd/yyyy):");
            Date checkOut = format.parse(scanner.nextLine());

            Collection<IRoom> rooms = hotelResource.findARoom(checkIn, checkOut);

            if (rooms.isEmpty()) {
                System.out.println("No rooms available.");
                return;
            }

            System.out.println("Available Rooms:");
            rooms.forEach(System.out::println);

            System.out.println("Enter room number:");
            String roomNumber = scanner.nextLine();

            System.out.println("Enter your email:");
            String email = scanner.nextLine();

            IRoom room = hotelResource.getRoom(roomNumber);

            hotelResource.bookARoom(email, room, checkIn, checkOut);

            System.out.println("Reservation successful!");

        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        }
    }
}