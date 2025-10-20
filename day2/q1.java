import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class q1 {
    public static void main(String[] args) {
        File myFile = new File("input.txt");
        Integer ans = 0;

        try (Scanner scanner = new Scanner(myFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                String[] stringArray = line.split("\\s+");
                Integer[] integerArray = convertToIntegerArray(stringArray);

                if (checkSafety(integerArray)) {
                    ans ++;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + e.getMessage());
            return;
        }
        System.out.println(ans);
    }

    public static Integer[] convertToIntegerArray(String[] stringArray) {
        Integer[] intArray = new Integer[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.valueOf(stringArray[i]);
        }

        return intArray;
    }

    public static boolean checkSafety(Integer[] integerArray) {
        int flag = 0; //ascending
        
        if (integerArray[1] < integerArray[0]) flag = 1; //descending

        for (int i = 1; i < integerArray.length; i++) {
            if (flag == 0) {
                if (integerArray[i] < integerArray[i-1]) return false;
            }else {
                if (integerArray[i] > integerArray[i-1]) return false;
            }
        }

        for (int i = 1; i < integerArray.length; i++) {
            int diff = Math.abs(integerArray[i] - integerArray[i-1]);

            if (diff < 1 || diff > 3) return false;
        }
        return true;
    }
}