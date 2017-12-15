package crackingTheCodingInterview;

public class IsThisABinarySearchTree {
    boolean checkBST(Node root) {
        boolean leftResult = true;
        int rightResult;
        boolean result = true;
        
        if (root.left != null) {
            result = result & checkNode(root.left, root.data,0);
        }
        if (root.right != null){
            result = result & checkNode(root.right, 10001,root.data);
        }
        
        return result;
    }


    boolean checkNode(Node node, int max, int min){
        boolean result = true;
        
        if (max <= node.data || min >= node.data) return false;
        
        if (node.left != null){
            result = result & checkNode(node.left, node.data, min);
        }
        
        if (node.right != null){
            result = result & checkNode(node.right, max, node.data);
        }
        
        
        return result;
    }
}
