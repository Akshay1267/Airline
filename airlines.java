import java.util.Scanner;
import java.util.ArrayList;

class airlines {
    private ArrayList<String> reservations;
    private int capacity;

    public airlines(int capacity) {
        this.capacity = capacity;
        reservations = new ArrayList<>();
    }

    public boolean makeReservation(String name) {
        if (reservations.size() < capacity) {
            reservations.add(name);
            System.out.println("Reservation confirmed for " + name);
            return true;
        } else {
            System.out.println("Sorry, no seats available.");
            return false;
        }
    }

    public void cancelReservation(String name) {
        if (reservations.remove(name)) {
            System.out.println("Reservation for " + name + " has been canceled.");
        } else {
            System.out.println("No reservation found for " + name);
        }
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations have been made.");
        } else {
            System.out.println("Current Reservations:");
            for (String name : reservations) {
                System.out.println("- " + name);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total capacity of the reservation system: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        airlines system = new airlines(capacity);
        
        while (true) {
            System.out.println("\n1. Make a reservation");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. View reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter your name for the reservation: ");
                    String name = scanner.nextLine();
                    system.makeReservation(name);
                    break;
                case 2:
                    System.out.print("Enter the name for the cancellation: ");
                    String cancelName = scanner.nextLine();
                    system.cancelReservation(cancelName);
                    break;
                case 3:
                    system.viewReservations();
                    break;
                case 4:
                    System.out.println("Exiting the reservation system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


