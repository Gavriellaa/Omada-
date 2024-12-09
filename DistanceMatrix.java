public class DistanceMatrix {
    private double[][] distances; // Δισδιάστατος πίνακας που αποθηκεύει τις αποστάσεις μεταξύ των πελατών

    // Κατασκευαστής που δημιουργεί πίνακα αποστάσεων συγκεκριμένου μεγέθους
    public DistanceMatrix(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }
        distances = new double[size][size];
    }

    // Μέθοδος για την προσθήκη απόστασης μεταξύ δύο πελατών στον πίνακα
    public void addDistance(int i, int j, double distance) {
        if (i < 0 || j < 0 || i >= distances.length || j >= distances.length) {
            throw new IndexOutOfBoundsException("Invalid indices for distance matrix.");
        }
        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative.");
        }
        distances[i][j] = distance;
        distances[j][i] = distance; // Συμμετρική ενημέρωση
    }

    // Μέθοδος για την ανάκτηση της απόστασης μεταξύ δύο πελατών
    public double getDistance(int i, int j) {
        if (i < 0 || j < 0 || i >= distances.length || j >= distances.length) {
            throw new IndexOutOfBoundsException("Invalid indices for distance matrix.");
        }
        return distances[i][j];
    }

    // Μέθοδος για έλεγχο αν έχει καταχωρηθεί απόσταση μεταξύ δύο πελατών
    public boolean isDistanceSet(int i, int j) {
        if (i < 0 || j < 0 || i >= distances.length || j >= distances.length) {
            throw new IndexOutOfBoundsException("Invalid indices for distance matrix.");
        }
        return distances[i][j] != 0 || distances[j][i] != 0;
    }

    // Μέθοδος για την εμφάνιση του πίνακα αποστάσεων
    public void display() {
        for (int i = 0; i < distances.length; i++) {
            for (int j = i + 1; j < distances[i].length; j++) {
                if (i == 0) {
                    System.out.println("Distance between depot and client " + j + " is: " + distances[i][j] + "km");
                } else {
                    System.out.println("Distance between client " + i + " and client " + j + " is: " + distances[i][j] + "km");
                }
            }
        }
    }

    // Μέθοδος για την εκκαθάριση όλων των αποστάσεων
    public void clearDistances() {
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances[i].length; j++) {
                distances[i][j] = 0;
            }
        }
    }
}
