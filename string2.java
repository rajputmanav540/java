import java.util.*;

public class string2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str;
        int s, e;
        System.out.println("Enter a text:");
        str = sc.nextLine();
        System.out.println("Enter the starting and end index for cutting a specific portion of the string:");

        s = sc.nextInt();
        e = sc.nextInt();
        String sub = str.substring(s, e);
        System.out.println("Cut portion of the string = " + sub);
    }

}
