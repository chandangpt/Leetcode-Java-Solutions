package com.chandan.topic.design.SerializeandDeserializeBinaryTree297;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Codec {

    private static final String SPLITER = ",";
    private static final String NULL_NODE = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        return sb.toString();
    }

    private void serializeUtil(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(NULL_NODE).append(SPLITER);
            return;
        }
        sb.append(root.val).append(SPLITER);
        serializeUtil(root.left, sb);
        serializeUtil(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(SPLITER)));
        return deserializeUtil(queue);
    }

    private TreeNode deserializeUtil(Deque<String> queue) {
        String val = queue.remove();
        if(val.equals(NULL_NODE)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = deserializeUtil(queue);
            node.right = deserializeUtil(queue);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
