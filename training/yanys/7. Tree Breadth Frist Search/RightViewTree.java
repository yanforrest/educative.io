import apple.laf.JRSUIUtils;

import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class RightViewTree {
   public static List<TreeNode> traverse(TreeNode root) {
      List<TreeNode> result = new ArrayList<>();

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while(!queue.isEmpty()){
         int length = queue.size();
         for(int i=0; i < length; i++){
            TreeNode cur = queue.poll();
            if(cur.left != null ) queue.add(cur.left);
            if(cur.right != null ) queue.add(cur.right);
            if(i == length-1) result.add(cur);
         }
      }

      return result;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(12);
      root.left = new TreeNode(7);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(9);
      root.right.left = new TreeNode(10);
      root.right.right = new TreeNode(5);
      root.left.left.left = new TreeNode(3);
      List<TreeNode> result = RightViewTree.traverse(root);
      for (TreeNode node : result) {
         System.out.print(node.val + " ");
      }
   }
}