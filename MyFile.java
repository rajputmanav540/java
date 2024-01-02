import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFile {
    public static void main(String[] args) {
        System.out.println("Dates in dd-MM-yyyy");
        try {
            File obj = new File("Dates.txt");
            Scanner sc = new Scanner(obj);

            while (sc.hasNextLine()) {
                String str = sc.nextLine();

                try {
                    // Parse the date using the appropriate format
                    Date date = parseDate(str);

                    // Reformat the date into "dd-MM-yyyy" format
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String formattedDate = outputFormat.format(date);

                    System.out.println(formattedDate);
                } catch (ParseException e) {
                    System.out.println("Error parsing date: " + str);
                    e.printStackTrace();
                }
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred!!");
            e.printStackTrace();
        }
    }

    private static Date parseDate(String dateString) throws ParseException {
        // Use a four-digit year format "yyyy"
        String[] formats = {
                "MM/dd/yyyy",
                "dd/MM/yyyy",
                "MM-dd-yyyy",
                "MM/dd/yy",
                "dd-MM-yyyy",
                "yyyy.MM.dd",
                "MM-dd-yy",
                "yyyy/MM/dd"
        };

        ParseException lastException = null;

        for (String format : formats) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                return sdf.parse(dateString);
            } catch (ParseException e) {
                // Save the last exception for reporting if none of the formats match
                lastException = e;
            }
        }

        // If no format matches, throw the last encountered exception
        throw lastException;
    }
}
