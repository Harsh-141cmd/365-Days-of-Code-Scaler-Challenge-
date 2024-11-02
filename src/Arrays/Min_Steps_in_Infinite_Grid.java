/*

Problem Description

You are in an infinite 2D grid where you can move in any of the 8 directions

 (x,y) to
    (x-1, y-1),
    (x-1, y)  ,
    (x-1, y+1),
    (x  , y-1),
    (x  , y+1),
    (x+1, y-1),
    (x+1, y)  ,
    (x+1, y+1)
You are given a sequence of points and the order in which you need to cover the points.. Give the minimum number of steps in which you can achieve it. You start from the first point.
NOTE: This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.


Problem Constraints
1 <= |A| <= 106
- 2 * 103 <= Ai, Bi <= 2 * 103
|A| == |B|


Input Format
Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.

Output Format
Return an Integer, i.e minimum number of steps.

Example Input
Input 1:
 A = [0, 1, 1]
 B = [0, 1, 2]

Example Output
Output 1:
 2

Example Explanation
Explanation 1:

 Given three points are: (0, 0), (1, 1) and (1, 2).
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

 */

package Arrays;

import java.util.Scanner;

public class Min_Steps_in_Infinite_Grid {
    public int coverPoints(int[] A, int[] B) {
        int steps = 0;
        for(int i=0; i<A.length-1; i++) {
            steps += Math.max(Math.abs(A[i+1] - A[i]), Math.abs(B[i+1] - B[i]));
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        System.out.println("Enter the elements of the array A:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println("Enter the elements of the array B:");
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        Min_Steps_in_Infinite_Grid main = new Min_Steps_in_Infinite_Grid();
        System.out.println(main.coverPoints(A, B));
    }
}