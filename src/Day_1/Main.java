/*
Problem: Majority Element

Problem Description:
Given an array of size N, find the majority element. The majority element is the element that appears more than floor(N/2) times.
You may assume that the array is non-empty and the majority element always exist in the array.


Problem Constraints
1 <= |A| <= 106
1 <= Ai <= 109


Input Format
The first argument is an integer array A.


Output Format
Return the majority element.


Example Input
A = [2, 1, 2]


Example Output
2


Example Explanation
2 occurs 2 times which is greater than 3/2.

 */

package Day_1;

import java.util.Scanner;
public class Main {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int majorityElement(final int[] A) {
        int N = A.length;

        for(int i=0; i<N; i++) {
            int count = 0;
            for(int j=0; j<N; j++) {
                if(A[i] == A[j]) {
                    count++;
                }
            }
            if(count > N/2) {
                return A[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Main main = new Main();
        int result = main.majorityElement(array);
        System.out.println("Majority Element: " + result);
        scanner.close();
    }
}