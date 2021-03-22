import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class ZigzagTraversal {
   public static List<List<Integer>> traverse(TreeNode root) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      Queue<TreeNode>  queue = new LinkedList<>();
      queue.add(root);
      boolean beOdd = false;
      while(!queue.isEmpty()){
         List<Integer> level = new LinkedList<>();
         int length = queue.size();
         for(int i=0;i<length; i++){
            TreeNode cur = queue.poll();
            if(cur.left!=null) queue.add(cur.left);
            if(cur.right!=null) queue.add(cur.right);

            if(beOdd) level.add(0, cur.val );
            else level.add(cur.val);

         }
         beOdd = !beOdd;
         result.add(level);
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
      root.right.left.left = new TreeNode(20);
      root.right.left.right = new TreeNode(17);
      List<List<Integer>> result = ZigzagTraversal.traverse(root);
      System.out.println("Zigzag traversal: " + result);
   }
}
