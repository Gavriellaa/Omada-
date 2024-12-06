import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    /**
     * Φορτώνει δεδομένα πελατών από ένα αρχείο CSV.
     * @param filePath το μονοπάτι του αρχείου CSV
     * @param delimiter το διαχωριστικό πεδίων (π.χ., ",")
     * @return λίστα αντικειμένων Client
     */
    public static List<Client> loadClientsFromCSV(String filePath, String delimiter) {
        List<Client> clients = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Παράβλεψη επικεφαλίδας
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (values.length != 3) { // Έλεγχος σωστής μορφής
                    System.err.println("Invalid line format: " + line);
                    continue;
                }
                try {
                    int id = Integer.parseInt(values[0]);
                    double x = Double.parseDouble(values[1]);
                    double y = Double.parseDouble(values[2]);
                    clients.add(new Client(id, x, y));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        }

        return clients;
    }

    /**
     * Φορτώνει πίνακα αποστάσεων από ένα αρχείο CSV.
     * @param filePath το μονοπάτι του αρχείου CSV
     * @param size το μέγεθος του πίνακα
     * @param delimiter το διαχωριστικό πεδίων
     * @return αντικείμενο DistanceMatrix
     */
    public static DistanceMatrix loadDistanceMatrixFromCSV(String filePath, int size, String delimiter) {
        DistanceMatrix matrix = new DistanceMatrix(size);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (values.length != size) { // Έλεγχος αν η γραμμή έχει σωστό αριθμό στηλών
                    System.err.println("Invalid row length at line " + (row + 1));
                    continue;
                }
                for (int col = 0; col < values.length; col++) {
                    try {
                        double distance = Double.parseDouble(values[col]);
                        matrix.addDistance(row, col, distance);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid distance value at row " + row + ", column " + col);
                    }
                }
                row++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        }

        return matrix;
    }
}
