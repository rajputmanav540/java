import java.util.Scanner;

public class Conversion {

    void convertAndPrint(int n) {
        String bin = Integer.toBinaryString(n);
        String octal = Integer.toOctalString(n);
        String hex = Integer.toHexString(n);

        System.out.println("Binary conversion of " + n + " =" + bin);
        System.out.println("Octal conversion of " + n + " =" + octal);
        System.out.println("Hexadecimal conversion of " + n + " = " + hex);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the decimal number :");
        int n = sc.nextInt();

        // Create an instance of the Conversion class
        Conversion converter = new Conversion();
        // Call the convertAndPrint method using the instance
        converter.convertAndPrint(n);
    }
}
