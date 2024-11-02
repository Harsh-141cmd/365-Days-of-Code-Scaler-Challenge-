/*

Problem Description



Given an integer array A of size N.
You have to pick exactly B elements from either left or right end of the array A to get the maximum sum.
Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then
You can pick the first four elements or can pick the last four elements or can pick 1 from the front and 3 from the back etc. you need to return the maximum possible sum of elements you can pick.


Problem Constraints
1 <= N <= 105
1 <= B <= N
-103 <= A[i] <= 103


Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return an integer denoting the maximum possible sum of elements you picked.


Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3

Input 2:

 A = [1, 2]
 B = 1


Example Output
Output 1:
 8

Output 2:
 2


Example Explanation

Explanation 1:
Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8

Explanation 2:
Pick element 2 from end as this is the maximum we can get

 */

package Arrays;

import java.util.Scanner;

public class Pick_from_both_sides {
    public int solve(int[] A, int B) {
        int n = A.length;
        int sum =0;
        int i , j = n-1;

        for( i=0; i<B ; i++) {
            sum+=A[i];
        }

        i--;
        int ans = sum;

        for(j=n-1 ; j>n-1-B ; j-- ) {
            sum = sum - A[i--] + A[j];
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        Pick_from_both_sides main = new Pick_from_both_sides();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.print("Enter the number of elements to pick from either end: ");
        int b = sc.nextInt();
        int result = main.solve(array, b);
        System.out.println("Maximum possible sum of elements you picked: " + result);


    }
}
