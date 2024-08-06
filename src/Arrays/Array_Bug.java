/*

The following code is supposed to rotate the array A by B positions.

So, for example,


A : [1 2 3 4 5 6]
B : 1

The output :

[2 3 4 5 6 1]
However, there is a small bug in the problem. Fix the bug and submit the problem.

 */


package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Array_Bug {
    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        int N = A.size();
        ArrayList<Integer> rotatedArray = new ArrayList<>(N);
        int rotateIndex = B % N;

        for (int i = rotateIndex; i < N; i++) {
            rotatedArray.add(A.get(i));
        }
        for (int i = 0; i < rotateIndex; i++) {
            rotatedArray.add(A.get(i));
        }
        return rotatedArray;
    }

    public static void main(String[] args) {
        Array_Bug arrayBug = new Array_Bug();
        ArrayList<Integer> testArray = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int B = 1;
        ArrayList<Integer> result = arrayBug.rotateArray(testArray, B);
        System.out.println(result);
    }
}
