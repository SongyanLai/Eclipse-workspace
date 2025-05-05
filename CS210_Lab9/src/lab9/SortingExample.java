package lab9;

import java.util.Random;

public class SortingExample {

    public static void main(String[] args) {
        // Generate a large array of random numbers (200+ numbers)
        int n = 300; // Number of elements to sort
        int[] arr = generateRandomArray(n);

        // Output the unsorted array
        System.out.println("Unsorted Array:");
        printArray(arr);

        // Determine sorting algorithm based on array size
        if (arr.length < 200) {
            System.out.println("\nUsing Merge Sort...");
            mergeSort(arr, 0, arr.length - 1);
        } else {
            System.out.println("\nUsing Bubble Sort...");
            bubbleSort(arr);
        }

        // Output the sorted array
        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    // Generate a random array with n elements
    public static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1000); // Random numbers between 0 and 999
        }
        return arr;
    }

    // Merge Sort Implementation
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { // Base condition
            int mid = left + (right - left) / 2; // Find the middle point to split the array

            // Recursively sort the first half
            mergeSort(arr, left, mid);

            // Recursively sort the second half
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Merge function for Merge Sort
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // Length of the first subarray
        int n2 = right - mid;    // Length of the second subarray

        // Create temporary arrays for the two subarrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays back into the original array
        int i = 0; // Initial index of left subarray
        int j = 0; // Initial index of right subarray
        int k = left; // Initial index of merged array

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) { // Compare and choose the smaller element
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of leftArray, if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements of rightArray, if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Bubble Sort Implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Helper method to print an array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

