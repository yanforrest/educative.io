import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class MinimumBinaryTreeDepth {
   public static int findDepth(TreeNode root) {
      if (root== null) return 0;
      int minimumTreeDepth = 0;

      Queue<TreeNode>  queue = new LinkedList<>();
      queue.add(root);
      boolean beOdd = false;
      while(!queue.isEmpty()){
         minimumTreeDepth++;
         int length = queue.size();
         for(int i=0;i<length; i++){
            TreeNode cur = queue.poll();
            if(cur.left!=null) queue.add(cur.left);
            if(cur.right!=null) queue.add(cur.right);
            if(cur.left == null && cur.right == null) {
               return minimumTreeDepth;
            }
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(12);
      root.left = new TreeNode(7);
      root.right = new TreeNode(1);
      root.right.left = new TreeNode(10);
      root.right.right = new TreeNode(5);
      System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
      root.left.left = new TreeNode(9);
      root.right.left.left = new TreeNode(11);
      System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
   }
}