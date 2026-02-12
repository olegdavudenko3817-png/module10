package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

class printNumberValidPhone {
    static void main(String[] args) {
        printNumberValidPhone("src/task1/file.txt");
    }

    public static void printNumberValidPhone(String fileName) {
        String regex = "^\\(\\d{3}\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String cleanLine = line.trim();

                if (!cleanLine.isEmpty() && pattern.matcher(line).matches()) {
                    System.out.println(cleanLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}