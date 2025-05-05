package lab6;

import java.util.Scanner;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= n - 1) {
                return true;
            }
        }
        return farthest >= n - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input in a single line
        System.out.println("Enter all the numbers separated by spaces:");
        String input = scanner.nextLine(); // Read the entire line

        // Split the input string by spaces and convert to an integer array
        String[] parts = input.split(" ");
        int[] nums = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        // Check if we can reach the last index
        boolean result = canJump(nums);

        // Print the result
        System.out.println("The answer is: " + result);
    }
}
