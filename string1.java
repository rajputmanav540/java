import java.util.*;

public class string1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        char v[] = new char[50];
        char ch, c1;
        int a = 0;
        int count;
        String str[] = new String[50];
        String st = "";
        String s1;

        System.out.println("Enter a string containing multiple words and numbers:");
        s = sc.nextLine();

        System.out.println("String you entered: " + s);
        System.out.println("Vowels in the string:");

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                    || ch == 'O' || ch == 'U') {
                v[a] = ch;
                a++;
            }
        }

        // Count occurrences for each vowel and print
        for (int i = 0; i < a; i++) {
            c1 = v[i];
            count = 0;

            // Check if the vowel has been counted before
            boolean alreadyCounted = false;
            for (int j = 0; j < i; j++) {
                if (c1 == v[j]) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (!alreadyCounted) {
                // Count occurrences for the current vowel
                for (int j = 0; j < a; j++) {
                    if (c1 == v[j]) {
                        count++;
                    }
                }
                System.out.println("The vowel " + c1 + " occurred in the string " + count + " times");
            }
        }

        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            while (ch != ' ' && i < s.length()) {
                st = st + ch;
                i++;
                if (i < s.length()) {
                    ch = s.charAt(i);
                }
            }

            str[b] = st;
            b++;
            st = ""; // Reset the temporary string
        }

        System.out.println("\nWords and numbers in the string:");

        for (int i = 0; i < b; i++) {
            System.out.println(str[i]);
        }

        for (int i = 0; i < b; i++) {
            // Check if the word is a palindrome
            s1 = "";
            for (int j = str[i].length() - 1; j >= 0; j--) {
                char ch1 = str[i].charAt(j);
                s1 = s1 + ch1;
            }
            // Convert both strings to lowercase for case-insensitive comparison
            if (str[i].toLowerCase().equals(s1.toLowerCase())) {
                System.out.println(str[i] + " is a palindrome.\n");
            }
        }
        System.out.println("\nNumeric values in the given string are:");
        for (int i = 0; i < b; i++) {
            int num = 0;
            String s2 = str[i];
            int flag = 0;
            for (int j = 0; j < s2.length(); j++) {

                if (Character.isDigit(s2.charAt(j))) {
                    num = Integer.valueOf(s2);
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                System.out.println(num);
        }
    }
}

// Q.) Create a program that reads a string containing multiple words and
// numbers (considered as numeric strings).
// Identify and count (a) The occurrences of each vowel in the entire string,
// and (b) Palindromes and display the results.
// Also, convert all the numeric strings into integers and display them.
