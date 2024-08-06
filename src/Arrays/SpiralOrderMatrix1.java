/*

Problem Description

Given a matrix of M * N elements (M rows, N columns), return all elements of the matrix in spiral order.

Problem Constraints
1 <= M, N <= 1000

Input Format
The first argument is a matrix A.

Output Format
Return an array of integers representing all elements of the matrix in spiral order.

Example Input
A =
    [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
    ]

Example Output
[1, 2, 3, 6, 9, 8, 7, 4, 5]

 */

package Arrays;

import java.util.Scanner;

public class SpiralOrderMatrix1 {
    public int[] spiralOrder(final int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[] result = new int[m * n];
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        int direction = 0;
        int index = 0;

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    result[index++] = A[top][i];
                }
                top++;
            }
            else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    result[index++] = A[i][right];
                }
                right--;
            }
            else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    result[index++] = A[bottom][i];
                }
                bottom--;
            }
            else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    result[index++] = A[i][left];
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralOrderMatrix1 spiralOrderMatrix1 = new SpiralOrderMatrix1();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns: ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] A = new int[m][n];
        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        int[] result = spiralOrderMatrix1.spiralOrder(A);
        System.out.println("The elements of the matrix in spiral order are: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
