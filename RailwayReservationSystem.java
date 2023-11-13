import java.util.Scanner;

class Train {
    private String trainName;
    private int availableSeats;

    public Train(String trainName, int availableSeats) {
        this.trainName = trainName;
        this.availableSeats = availableSeats;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int numSeats) {
        if (numSeats > 0 && numSeats <= availableSeats) {
            availableSeats -= numSeats;
            System.out.println(numSeats + " seat(s) booked successfully for " + trainName);
        } else {
            System.out.println("Sorry, not enough seats available for booking.");
        }
    }
}

class ReservationSystem {
    private Train[] trains;

    public ReservationSystem() {
        // Initialize trains with some initial data
        trains = new Train[]{
                new Train("Express 101", 50),
                new Train("Superfast 202", 30),
                new Train("Local 303", 100)
        };
    }

    public void displayAvailableTrains() {
        System.out.println("Available Trains:");
        for (Train train : trains) {
            System.out.println(train.getTrainName() + " - Available Seats: " + train.getAvailableSeats());
        }
        System.out.println();
    }

    public void bookSeats(String trainName, int numSeats) {
        for (Train train : trains) {
            if (train.getTrainName().equals(trainName)) {
                train.bookSeats(numSeats);
                return;
            }
        }
        System.out.println("Train not found.");
    }
}

public class RailwayReservationSystem {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);
        

        while (true) {
            System.out.println("1. Display Available Trains");
            System.out.println("2. Book Seats");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reservationSystem.displayAvailableTrains();
                    break;
                case 2:
                    System.out.print("Enter the train name: ");
                    String trainName = scanner.next();
                    System.out.print("Enter the number of seats to book: ");
                    int numSeats = scanner.nextInt();
                    reservationSystem.bookSeats(trainName, numSeats);
                    break;
                case 3:
                    System.out.println("Exiting the program. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    scanner.close();
            }
        }
    }
}
