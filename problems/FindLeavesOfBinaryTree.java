
import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, collect a tree's nodes as if you were doing this:

Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.

Time complexity: O(N)
Space complexity: O(N)
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class FindLeavesOfBinaryTree {

    private List<List<Integer>> solution;

    private int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        if (this.solution.size() == currHeight) {
            this.solution.add(new ArrayList<>());
        }

        this.solution.get(currHeight).add(root.val);

        return currHeight;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        this.solution = new ArrayList<>();

        getHeight(root);

        return this.solution;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        FindLeavesOfBinaryTree solution = new FindLeavesOfBinaryTree();
        List<List<Integer>> result = solution.findLeaves(root);

        System.out.println(result);
    }

}
