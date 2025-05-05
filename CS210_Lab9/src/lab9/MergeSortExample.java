package lab9;

import java.util.Scanner;

public class MergeSortExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Get the size of the array
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        // Input: Read the array elements
        System.out.println("Please enter the elements of the array (separated by spaces):");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the mergeSort method to sort the array
        mergeSort(arr, 0, arr.length - 1);

        // Output the sorted array in the desired format
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }


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
}
