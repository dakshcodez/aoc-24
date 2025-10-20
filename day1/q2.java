import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class q2 {
    public static void main(String[] args) {
        File myFile = new File("input1.txt");

        List<Integer> firstIntegers = new ArrayList<>();
        List<Integer> secondIntegers = new ArrayList<>();

        try (Scanner scanner = new Scanner(myFile)) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split("\\s+");

                firstIntegers.add(Integer.parseInt(parts[0]));
                secondIntegers.add(Integer.parseInt(parts[1]));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + e.getMessage());
            return;
        }

        Integer ans = 0;

        for (int i = 0; i < firstIntegers.size(); i++) {
            Integer currInteger = firstIntegers.get(i);
            Integer count = 0;
            for (int j = 0; j < secondIntegers.size(); j++) {
                if (secondIntegers.get(j).equals(currInteger)){
                    count++;
                }
            }
            //System.out.println(count);
            ans += currInteger * count;
        }

        System.out.println(ans);
    }
}
