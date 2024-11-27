import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    /**
     * Διαβάζει δεδομένα πελατών από τη γραμμή εντολών.
     * @return λίστα αντικειμένων Client
     */
    public static List<Client> readClientsFromConsole() {
        List<Client> clients = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of clients:");
            int numClients = scanner.nextInt();
            scanner.nextLine(); // Καθαρισμός εισόδου

            for (int i = 0; i < numClients; i++) {
                System.out.println("Enter client ID, x, and y (separated by spaces):");
                String input = scanner.nextLine();
                String[] values = input.split("\\s+"); // Διαχωρισμός με βάση τα κενά
                if (values.length != 3) {
                    System.err.println("Invalid input format. Expected: ID x y");
                    i--; // Επανεκτέλεση για τον ίδιο πελάτη
                    continue;
                }
                try {
                    int id = Integer.parseInt(values[0]);
                    double x = Double.parseDouble(values[1]);
                    double y = Double.parseDouble(values[2]);
                    clients.add(new Client(id, x, y));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format. Try again.");
                    i--; // Επανεκτέλεση για τον ίδιο πελάτη
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading input. Please restart the program.");
        }

        return clients;
    }
}
