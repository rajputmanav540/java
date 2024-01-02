import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MyFile1 {
    public static void main(String[] args) {
        try {
            File file = new File("Numbers.csv");
            Scanner sc = new Scanner(file);
            sc.useDelimiter(",");
            
            ArrayList<Double> numbers = new ArrayList<>();

            while (sc.hasNext()) {
                String nextValue = sc.next();
                double value = Double.parseDouble(nextValue);
                numbers.add(value);
            }

            // Calculate mean
            double mean = Mean(numbers);
            System.out.println("Mean: " + mean);

            // Calculate median
            double median = Median(numbers);
            System.out.println("Median: " + median);

            // Calculate standard deviation
            double standardDeviation = StandardDeviation(numbers);
            System.out.println("Standard Deviation: " + standardDeviation);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static double Mean(ArrayList<Double> numbers) {
        double sum = 0;

        for (double number : numbers) {
            sum += number;
        }

        return sum / numbers.size();
    }

    private static double Median(ArrayList<Double> numbers) {
        Collections.sort(numbers);

        int size = numbers.size();
        if (size % 2 == 0) {
            int middle = size / 2;
            return (numbers.get(middle - 1) + numbers.get(middle)) / 2.0;
        } else {
            return numbers.get(size / 2);
        }
    }

    private static double StandardDeviation(ArrayList<Double> numbers) {
        double mean = Mean(numbers);
        double sumSquaredDiff = 0;

        for (double number : numbers) {
            double diff = number - mean;
            sumSquaredDiff += diff * diff;
        }

        double variance = sumSquaredDiff / numbers.size();
        return Math.sqrt(variance);
    }
}
