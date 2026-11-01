import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int inputSize = sc.nextInt();
        int[] input = new int[inputSize];
        for (int i = 0; i < inputSize; i++) {
            input[i] = sc.nextInt();
        }
        
        for (int i = 1; i < 4; i++) { 
            int key = input[i]; 
            int j = i - 1;
            while (j >= 0 && input[j] < key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key; 
        }

        System.out.println(Arrays.toString(input));
        int targets = sc.nextInt();

        for (int i = 0; i < targets; i++) {
            int target = sc.nextInt();
            int index = -1;
            for (int j = 0; j < inputSize; j++) {
                if (input[j] == target) {
                    index = j;
                    break;
                }
            }
            if (index >= 0) {
                System.out.println(target + ": FOUND at index " + index);
            } else {
                System.out.println(target + ": NOT FOUND");
            }
        }
    }
}
