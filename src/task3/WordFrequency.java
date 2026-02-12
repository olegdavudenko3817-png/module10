package task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {

    static void main(String[] args) throws IOException {
        countWords("src/task3/words.txt");
    }

    public static void countWords(String fileName) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");

            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        reader.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
