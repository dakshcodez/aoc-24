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
        int i = 1;

        while (i < integerArray.length - 1) {
            int diff1 = Math.abs(integerArray[i] - integerArray[i-1]);
            int diff2 = Math.abs(integerArray[i] - integerArray[i+1]);

            if ((integerArray[i] > integerArray[i-1]) && (integerArray[i] < integerArray[i+1]) && (diff1 >= 1 && diff1 <= 3) && (diff2 >= 1 && diff2 <= 3)) {
                i++;
            } else if ((integerArray[i] < integerArray[i-1]) && (integerArray[i] > integerArray[i+1]) && (diff1 >= 1 && diff1 <= 3) && (diff2 >= 1 && diff2 <= 3)) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}