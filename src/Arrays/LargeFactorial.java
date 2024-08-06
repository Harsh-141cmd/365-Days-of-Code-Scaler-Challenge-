/*

Problem Description - Large Factorial

Given a number A. Find the fatorial of the number.



Problem Constraints
1 <= A <= 100



Input Format
First and only argument is the integer A.

Output Format
Return a string, the factorial of A.

Example Input
Input 1:

A = 2

Input 2:

A = 3


Example Output
Output 1:

 2

Output 2:

 6


Example Explanation
Explanation 1:

2! = 2 .

Explanation 2:

3! = 6 .

 */

package Arrays;
import java.math.BigInteger;
import java.util.Scanner;

public class LargeFactorial {
    public String solve(int A) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 2; i <= A; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LargeFactorial lf = new LargeFactorial();
        int A = sc.nextInt();
        System.out.println(lf.solve(A));
    }
}
