/*
Problem Description

You are given an integer array A.
You have to find the number of occurences of each number.
Return an array containing only the occurences with the smallest value's occurence first.

For example, A = [4, 3, 3], you have to return an array [2, 1], where 2 is the number of occurences for element 3,
and 1 is the number of occurences for element 4. But, 2 comes first because 3 is smaller than 4.

Problem Constraints
1 <= |A| <= 105
1 <= Ai <= 109

Input Format
The first argument is the integer array A.

Output Format
Return an integer array denoting the occurences of each number.

Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [4, 3, 3]

Example Output
Output 1:
[1, 1, 1]
Output 2:
[2, 1]

Example Explanation
Explanation 1:
All the elements occur once, so the resultant array should be [1, 1, 1].
Explanation 2:
Explained in the description above.
*/

package Arrays;
import java.util.Scanner;

public class Occurence_of_Each_Number {
    public int[] solve(int[] A) {
        int n = A.length;
        int[] count = new int[1000000001];
        for (int i = 0; i < n; i++) {
            count[A[i]]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (count[A[i]] < min) {
                min = count[A[i]];
            }
        }
        int[] ans = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (count[A[i]] == min) {
                ans[j++] = A[i];
                count[A[i]] = 0;
            }
        }
        int[] res = new int[j];
        for (int i = 0; i < j; i++) {
            res[i] = ans[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Occurence_of_Each_Number main = new Occurence_of_Each_Number();
        int[] result = main.solve(array);
        System.out.println("Occurences of each number:");
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
