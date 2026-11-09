import java.util.*;
public class Main {
    static void selectionSort(int[] arr, int passes) {
        int n = arr.length;
        for (int i = 0; i < passes && i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int inputSize = sc.nextInt();
        int[] input = new int[inputSize];
        for (int i = 0; i < inputSize; i++) {
            input[i] = sc.nextInt();
        }
        selectionSort(input, 2);

        for (int i = 0; i < inputSize; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();

        int targets = sc.nextInt();
        for (int i = 0; i < targets; i++) {
            int target = sc.nextInt();
            int index = linearSearch(input, target);
            if (index >= 0) {
                System.out.println(target + ": FOUND at index " + index);
            } else {
                System.out.println(target + ": NOT FOUND");
            }
        }
    }
}
