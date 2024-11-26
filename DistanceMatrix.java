public class DistanceMatrix {
    private double[][] distances; 

    public DistanceMatrix(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }
        distances = new double[size][size];
    }

    
    public void addDistance(int i, int j, double distance) {
        if (i < 0 || j < 0 || i >= distances.length || j >= distances.length) {
            throw new IndexOutOfBoundsException("Invalid indices for distance matrix.");
        }
        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative.");
        }
        distances[i][j] = distance;
        distances[j][i] = distance; 
    }

    
    public double getDistance(int i, int j) {
        if (i < 0 || j < 0 || i >= distances.length || j >= distances.length) {
            throw new IndexOutOfBoundsException("Invalid indices for distance matrix.");
        }
        return distances[i][j];
    }

    
    public boolean isDistanceSet(int i, int j) {
        if (i < 0 || j < 0 || i >= distances.length || j >= distances.length) {
            throw new IndexOutOfBoundsException("Invalid indices for distance matrix.");
        }
        return distances[i][j] != 0 || distances[j][i] != 0;
    }

    
    public void display() {
        System.out.println("Distance Matrix:");
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances[i].length; j++) {
                System.out.printf("%.2f ", distances[i][j]);
            }
            System.out.println();
        }
    }

    
    public void clearDistances() {
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances[i].length; j++) {
                distances[i][j] = 0;
            }
        }
    }
}
