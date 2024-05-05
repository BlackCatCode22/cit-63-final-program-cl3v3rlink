import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchComplexity {

    // Linear Search Method
    public static int linearSearch(int[] array, int target) {
        int iterations = 0;
        for (int i = 0; i < array.length; i++) {
            iterations++;
            if (array[i] == target) {
                System.out.println("Linear search iterations: " + iterations);
                return i;  // Returns index of found element
            }
        }
        System.out.println("Linear search iterations: " + iterations);
        return -1;  // Target not found
    }

    // Binary Search Method (Recursive)
    public static int binarySearchRecursive(int[] array, int target, int left, int right, int iterations) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            iterations++;
            if (array[mid] == target) {
                System.out.println("Binary search iterations: " + iterations);
                return mid;  // Element found
            }
            if (array[mid] < target) {
                return binarySearchRecursive(array, target, mid + 1, right, iterations);
            } else {
                return binarySearchRecursive(array, target, left, mid - 1, iterations);
            }
        }
        System.out.println("Binary search iterations: " + iterations);
        return -1; // Element not found
    }

    // Binary Search Method
    public static int binarySearch(int[] array, int target) {
        return binarySearchRecursive(array, target, 0, array.length - 1, 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter number of elements in array:");
            int n = scanner.nextInt();
            if (n <= 0) {
                throw new IllegalArgumentException("Number of elements must be positive.");
            }
            int[] array = new int[n];

            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            System.out.println("Enter target number to search:");
            int target = scanner.nextInt();

            // Linear Search
            int linearResult = linearSearch(array, target);
            System.out.println((linearResult == -1) ? "Target not found by linear search." :
                    "Target found by linear search at index: " + linearResult);

            // Binary Search (Array must be sorted)
            Arrays.sort(array);
            int binaryResult = binarySearch(array, target);
            System.out.println((binaryResult == -1) ? "Target not found by binary search." :
                    "Target found by binary search at index: " + binaryResult);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
