/*
Problem: Longest Increasing Subsequence

Problem Description

Find the longest increasing subsequence of a given array of integers, A.
In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.
In this case, return the length of the longest increasing subsequence.


Problem Constraints
1 <= length(A) <= 2500
0 <= A[i] <= 2500


Input Format
The first and the only argument is an integer array A.


Output Format
Return an integer representing the length of the longest increasing subsequence.


Example Input
Input 1:
 A = [1, 2, 1, 5]
Input 2:
 A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]


Example Output
Output 1:
 3
Output 2:
 6


Example Explanation
Explanation 1:
 The longest increasing subsequence: [1, 2, 5]
Explanation 2:
 The possible longest increasing subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 */

package Day_2;

import java.util.Scanner;
public class Main {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lis(final int[] A) {
        int N = A.length;
        int B[] = new int[N];

        for(int i=0; i<N; i++) {
            B[i] = 1;
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(A[i] > A[j] && B[i] < B[j] + 1) {
                    B[i] = B[j] + 1;
                }
            }
        }

        int count = 0;
        for(int i=0; i<N; i++) {
            if(B[i] > count) {
                count = B[i];
            }
        }

        return count;
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
        Main solution = new Main();
        int result = solution.lis(array);
        System.out.println("Length of the longest increasing subsequence: " + result);
        scanner.close();
    }
}