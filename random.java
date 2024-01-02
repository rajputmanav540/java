import java.util.*;
public class random {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> randomNumbersList = new ArrayList<>();
        Random r1 = new Random();
        System.out.println("Enter the range of random numbers :");
        int n=sc.nextInt();

        // Generate and store 10 random numbers in the ArrayList
        for (int i = 0; i < n; i++) {
            int num = r1.nextInt(n)+1; 
            randomNumbersList.add(num);
        }

        // Display the generated random numbers
        System.out.println("Generated random numbers are: " + randomNumbersList);
        // Sort the list in ascending order
        Collections.sort(randomNumbersList);

        // Convert the ArrayList to an array of primitive int values
        int[] intArray = new int[randomNumbersList.size()];
        for (int i = 0; i < randomNumbersList.size(); i++) {
            intArray[i] = randomNumbersList.get(i);
        }

        // Display the sorted array of primitive int values
        System.out.println("Sorted array of primitive int values: " + Arrays.toString(intArray));
    }
}