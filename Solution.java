import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = new String[3];
        String str[] = new String[3];
        int num[] = new int[3];
        int k;

        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            s[i] = sc.next();
        }

        for (int j = 0; j < 3; j++) {
            for (k = 0; k < s[j].length(); k++) {
                char ch = s[j].charAt(k);
                if (ch == ' ') {
                    break;
                }
            }
            str[j] = s[j].substring(0, k);
            String n = s[j].substring(k + 1, s[j].length());

            try {
                num[j] = Integer.parseInt(n);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for integer: " + n);
                // Handle the error or exit the program if necessary
            }
        }

        for (int x = 0; x < 3; x++) {
            // Adjust the number of spaces for formatting
            System.out.println(str[x] + "               " + num[x]);
        }

        System.out.println("================================");

        // Close the Scanner
        sc.close();
    }
}


