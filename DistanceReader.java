import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DistanceReader {

    public static DistanceMatrix readDistanceMatrix(String filename, int size) {
        DistanceMatrix matrix = new DistanceMatrix(size); 

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); 
                for (int col = 0; col < values.length; col++) {
                    double distance = Double.parseDouble(values[col]); 
                    matrix.addDistance(row, col, distance); 
                }
                row++; 
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }

        return matrix; 
    }
}
