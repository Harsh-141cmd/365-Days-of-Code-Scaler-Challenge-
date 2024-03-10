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

    // Helper function to create a binary tree from given array
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