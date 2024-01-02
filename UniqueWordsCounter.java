import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordsCounter {
    public static void main(String[] args) {
        String fileName = "example.txt";
        Set<String> uniqueWords = new HashSet<>();
        Map<String, Integer> wordFrequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line, uniqueWords, wordFrequency);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Word frequency: " + wordFrequency);
    }

    private static void processLine(String line, Set<String> uniqueWords, Map<String, Integer> wordFrequency) {
        String[] words = line.split("\\s+");
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            uniqueWords.add(lowerCaseWord);
            wordFrequency.merge(lowerCaseWord, 1, Integer::sum);
        }
    }
}
