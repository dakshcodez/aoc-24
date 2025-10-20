import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class q1 {
    public static void main(String[] args) {
        File myFile = new File("input1.txt");
        
        List<Integer> firstNumbers = new ArrayList<>();
        List<Integer> secondNumbers = new ArrayList<>();

        try (Scanner scanner = new Scanner(myFile)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split("\\s+");

                if (parts.length == 2) {
                    try {
                        firstNumbers.add(Integer.parseInt(parts[0]));
                        secondNumbers.add(Integer.parseInt(parts[1]));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping malformed line: " + line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + e.getMessage());
            return;
        }

        Collections.sort(firstNumbers);
        Collections.sort(secondNumbers);

        Integer sum = 0;

        for (int i = 0; i < firstNumbers.size(); i++) {
            sum += Math.abs(firstNumbers.get(i) - secondNumbers.get(i));
        }

        System.out.println(sum);
    }
}