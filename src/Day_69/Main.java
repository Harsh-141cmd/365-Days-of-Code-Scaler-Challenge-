/*
Problem: Reverse Level Order

Problem Description
Given a binary tree, return the reverse level order traversal of its nodes values. (i.e, from left to right and from last level to starting level).


Problem Constraints
1 <= number of nodes <= 5 * 105
1 <= node value <= 105


Input Format
First and only argument is a pointer to the root node of the Binary Tree, A.

Output Format
Return an integer array denoting the reverse level order traversal from left to right.


Example Input

Input 1:
    3
   / \
  9  20
    /  \
   15   7

Input 2:
   1
  / \
 6   2
    /
   3


Example Output

Output 1:
 [15, 7, 9, 20, 3]
Output 2:
 [3, 6, 2, 1]


Example Explanation

Explanation 1:
 Nodes as level 3 : [15, 7]
 Nodes at level 2: [9, 20]
 Nodes at level 1: [3]
 Reverse level order traversal will be: [15, 7, 9, 20, 3]

Explanation 2:
 Nodes as level 3 : [3]
 Nodes at level 2: [6, 2]
 Nodes at level 1: [1]
 Reverse level order traversal will be: [3, 6, 2, 1]

 */

package Day_69;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class Main {
    public ArrayList<Integer> reverseLevelOrder(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.addAll(0, levelNodes);
        }

        return result;
    }

    public TreeNode createTree(ArrayList<Integer> A, int index) {
        if (index >= A.size() || A.get(index) == -1) return null;

        TreeNode root = new TreeNode(A.get(index));
        root.left = createTree(A, 2 * index + 1);
        root.right = createTree(A, 2 * index + 2);

        return root;
    }
    public static void main(String[] args) {
        Main solution = new Main();
        Scanner scanner = new Scanner(System.in);

        // Input binary tree elements
        System.out.println("Enter the elements of the binary tree level by level (-1 for null):");
        ArrayList<Integer> input = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();
            if (val == -1) break;
            input.add(val);
        }

        // Construct binary tree
        TreeNode root = solution.createTree(input, 0);

        // Reverse level order traversal
        ArrayList<Integer> result = solution.reverseLevelOrder(root);
        System.out.println("Reverse Level Order Traversal: " + result);
    }
}