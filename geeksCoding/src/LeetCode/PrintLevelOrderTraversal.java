package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOrderTraversal {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static void printLevel(TreeNode node) {
        if (node == null) {
            System.out.print("sum: " + 0 + " average: " + 0 );
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(node);

        while(!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode current = q.poll();
                if (current.left != null) {
                    level.add(current.left.val);
                    q.offer(current.left);
                }
                if (current.right != null) {
                    level.add(current.right.val);
                    q.offer(current.right);
                }
            }
            System.out.println("sum: " + sum(level) + " average: " + average(level)); // we can use stringbuilder
        }

    }

    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    public static double average(ArrayList<Integer> list) {
        return list.size() == 0 ? 0 : sum(list) / list.size();
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        printLevel(root);
    }
}