package ui;

import api.AdminResource;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    private static final AdminResource adminResource = AdminResource.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {

        boolean running = true;

        while (running) {

            System.out.println("\nAdmin Menu");
            System.out.println("1. See all Customers");
            System.out.println("2. See all Rooms");
            System.out.println("3. See all Reservations");
            System.out.println("4. Add a Room");
            System.out.println("5. Back to Main Menu");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    Collection customers = adminResource.getAllCustomers();
                    customers.forEach(System.out::println);
                    break;

                case "2":
                    Collection<IRoom> rooms = adminResource.getAllRooms();
                    rooms.forEach(System.out::println);
                    break;

                case "3":
                    adminResource.displayAllReservations();
                    break;

                case "4":
                    addRoom();
                    break;

                case "5":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void addRoom() {

        try {

            List<IRoom> rooms = new ArrayList<>();

            System.out.println("Enter Room Number:");
            String number = scanner.nextLine();

            System.out.println("Enter Price:");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter Room Type (1 SINGLE, 2 DOUBLE):");
            int type = Integer.parseInt(scanner.nextLine());

            RoomType roomType = (type == 1) ? RoomType.SINGLE : RoomType.DOUBLE;

            rooms.add(new Room(number, price, roomType));

            adminResource.addRoom(rooms);

            System.out.println("Room added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }
}