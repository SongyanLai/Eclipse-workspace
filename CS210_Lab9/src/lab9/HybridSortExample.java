package lab9;

import java.util.Random;

public class HybridSortExample {

    public static void main(String[] args) {
        // Generate a large array of random numbers (300+ numbers)
        int n = 300; // Number of elements to sort
        int[] arr = generateRandomArray(n);

        // Output the unsorted array
        System.out.println("Unsorted Array:");
        printArray(arr);

        // Perform the hybrid sorting
        hybridMergeSort(arr, 0, arr.length - 1);

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

    // Hybrid Merge Sort: Switch to insertion sort for small arrays
    public static void hybridMergeSort(int[] arr, int left, int right) {
        int threshold = 200; // Threshold for switching to insertion sort

        if (right - left + 1 <= threshold) {
            // Switch to insertion sort for small arrays
            insertionSort(arr, left, right);
        } else {
            // Continue with merge sort for larger arrays
            if (left < right) {
                int mid = left + (right - left) / 2;

                // Recursively sort the two halves
                hybridMergeSort(arr, left, mid);
                hybridMergeSort(arr, mid + 1, right);

                // Merge the two sorted halves
                merge(arr, left, mid, right);
            }
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

    // Insertion Sort for small subarrays
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[left..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
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

