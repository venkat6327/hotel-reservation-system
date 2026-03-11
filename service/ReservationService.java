package service;

import model.*;

import java.util.*;

public class ReservationService {

    private static ReservationService instance = new ReservationService();

    private Map<String, IRoom> rooms = new HashMap<>();
    private Collection<Reservation> reservations = new ArrayList<>();

    private ReservationService(){}

    public static ReservationService getInstance() {
        return instance;
    }

    public void addRoom(IRoom room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId) {
        return rooms.get(roomId);
    }

    public Reservation reserveRoom(Customer customer, IRoom room,
                                   Date checkInDate, Date checkOutDate) {

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);

        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

        Set<IRoom> availableRooms = new HashSet<>(rooms.values());

        for (Reservation reservation : reservations) {

            if (!(checkOutDate.before(reservation.getCheckInDate()) ||
                    checkInDate.after(reservation.getCheckOutDate()))) {

                availableRooms.remove(reservation.getRoom());
            }
        }

        return availableRooms;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {

        List<Reservation> customerReservations = new ArrayList<>();

        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().equals(customer)) {
                customerReservations.add(reservation);
            }
        }

        return customerReservations;
    }

    public void printAllReservation() {

        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}