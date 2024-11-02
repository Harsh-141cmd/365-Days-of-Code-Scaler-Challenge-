/*
Problem Description

Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example:
for this problem, following are some good questions to ask :

Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Problem Constraints
1 <= |A| <= 106
0 <= Ai <= 9


Input Format
First argument is an array of digits.

Output Format
Return the array of digits after adding one.


Example Input
Input 1:
[1, 2, 3]

Example Output
Output 1:
[1, 2, 4]

Example Explanation
Explanation 1:
Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.

 */

package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Add_One_To_Number {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int N = A.size();
        int C = 1;

        for(int i=N-1; i>=0; i--) {
            int digit = A.get(i) + C;

            if(digit != 10) {
                A.set(i, digit);
                C = 0;
                break;
            }
            else {
                A.set(i, 0);
            }
        }
        if(C == 1) {
            A.add(0, 1);
        }
        while (A.size() > 1 && A.get(0) == 0) {
            A.remove(0);
        }
        return A;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Add_One_To_Number ob = new Add_One_To_Number();
        int n = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }
        System.out.println(ob.plusOne(A));
    }
}
