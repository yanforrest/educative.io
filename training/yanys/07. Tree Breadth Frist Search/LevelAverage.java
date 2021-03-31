import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class LevelAverage {
   public static List<Double> findLevelAverages(TreeNode root) {
      List<Double> result = new ArrayList<>();

      Queue<TreeNode>  queue = new LinkedList<>();
      queue.add(root);
      boolean beOdd = false;
      while(!queue.isEmpty()){
         Double sum = 0.0;
         int length = queue.size();
         for(int i=0;i<length; i++){
            TreeNode cur = queue.poll();
            if(cur.left!=null) queue.add(cur.left);
            if(cur.right!=null) queue.add(cur.right);
            sum += cur.val;
         }
         result.add(sum/length);
      }

      return result;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(12);
      root.left = new TreeNode(7);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(9);
      root.left.right = new TreeNode(2);
      root.right.left = new TreeNode(10);
      root.right.right = new TreeNode(5);
      List<Double> result = LevelAverage.findLevelAverages(root);
      System.out.print("Level averages are: " + result);
   }
}