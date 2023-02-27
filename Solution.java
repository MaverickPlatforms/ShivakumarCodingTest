import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.io.IOException;

class Solution {

    public static void main(String[] args) {
        String[] words = readFile("/home/coderpad/data/example2.txt");
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (!anagramGroups.containsKey(sortedWord)) {
                anagramGroups.put(sortedWord, new ArrayList<>());
            }
            anagramGroups.get(sortedWord).add(word);
        }
        for (List<String> group : anagramGroups.values()) {
            System.out.println(group);
        }
    }
    // Method to read the file and convert into array of string
    public static String[] readFile(String fileName) {
        List<String> lines = new ArrayList<>();  
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }    
        return lines.toArray(new String[0]);
    }
}
