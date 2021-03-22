import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class LevelOrderTraversal {
   public static List<List<Integer>> traverse(TreeNode root) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      if(root==null) return result;


      Queue<TreeNode> queue = new LinkedList<>();

      queue.add(root);
      while(!queue.isEmpty()){
         List<Integer> level= new ArrayList<>();
         int length = queue.size();
         for(int i=0; i< length; i++){
            TreeNode node = queue.poll();
            if(node.left != null)  queue.add(node.left);
            if(node.right != null)  queue.add(node.right);
            level.add(node.val);
         }
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
      List<List<Integer>> result = LevelOrderTraversal.traverse(root);
      System.out.println("Level order traversal: " + result);
   }
}
