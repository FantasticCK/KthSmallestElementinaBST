package com.CK;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(51);
        TreeNode node1 = new TreeNode(31);
        TreeNode node2 = new TreeNode(61);
        TreeNode node3 = new TreeNode(21);
        TreeNode node4 = new TreeNode(41);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node9 = new TreeNode(8);
//        TreeNode node10 = new TreeNode(9);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node13 = new TreeNode(9);
//        TreeNode node14 = new TreeNode(8);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;
//        node4.left = node9;
//        node4.right = node10;
//        node6.left = node13;
//        node6.right = node14;
        node3.left = new TreeNode(11);
        node3.left.right = new TreeNode(12);
        node3.left.right.right = new TreeNode(13);

        Solution2 solution = new Solution2();
        System.out.println(solution.kthSmallest(root, 100));
    }
}

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        ArrayList<Integer> inorderArr = inorderTraversal(root, k);
        return inorderArr.get(inorderArr.size() - 1);
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (result.size() < k) result.add(node.val);
            else break;

            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return result;
    }
}

// Iteration
class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
    }
}