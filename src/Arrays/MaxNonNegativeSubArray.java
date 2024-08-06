/*

Problem Description - Max Non Negative SubArray

Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.

The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array.

Find and return the required subarray.

NOTE:

If there is a tie, then compare with segment's length and return segment which has maximum length.
If there is still a tie, then return the segment with minimum starting index.


Problem Constraints
1 <= N <= 105

-109 <= A[i] <= 109


Input Format
The first and the only argument of input contains an integer array A, of length N.


Output Format
Return an array of integers, that is a subarray of A that satisfies the given conditions.


Example Input
Input 1:

 A = [1, 2, 5, -7, 2, 3]
Input 2:

 A = [10, -1, 2, 3, -4, 100]


Example Output
Output 1:

 [1, 2, 5]
Output 2:

 [100]


Example Explanation
Explanation 1:

 The two sub-arrays are [1, 2, 5] [2, 3].
 The answer is [1, 2, 5] as its sum is larger than [2, 3].

Explanation 2:

 The three sub-arrays are [10], [2, 3], [100].
 The answer is [100] as its sum is larger than the other two.

 */

package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class MaxNonNegativeSubArray {
    public int[] maxset(int[] A) {
        long maxSum = Integer.MIN_VALUE;
        long currentSum = 0;
        int start = 0;
        int end = -1;
        int maxStart = 0;
        int maxEnd = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                currentSum += A[i];
                end = i;
            } else {
                currentSum = 0;
                start = i + 1;
                end = i;
            }

            if (currentSum > maxSum || (currentSum == maxSum && (end - start > maxEnd - maxStart))) {
                maxSum = currentSum;
                maxStart = start;
                maxEnd = end;
            }
        }

        if (maxStart <= maxEnd) {
            int[] result = new int[maxEnd - maxStart + 1];
            for (int i = maxStart; i <= maxEnd; i++) {
                result[i - maxStart] = A[i];
            }
            return result;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        MaxNonNegativeSubArray maxNonNegativeSubArray = new MaxNonNegativeSubArray();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the array:");
        int length = sc.nextInt();
        int[] array = new int[length];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        int[] result = maxNonNegativeSubArray.maxset(array);
        System.out.println(Arrays.toString(result));
    }
}