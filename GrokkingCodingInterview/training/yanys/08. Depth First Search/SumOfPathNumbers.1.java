import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class SumOfPathNumbers {
   public static int findSumOfPathNumbers(TreeNode root) {
      // TODO: Write your code here
      List<Integer> allPathSum = new ArrayList<>();
      int currentPathSum = 0;
      findAllThePaths( root, currentPathSum, allPathSum);

      int sum = 0;
      for ( int i=0; i < allPathSum.size();i++){
         sum += allPathSum.get(i);
      }

      return sum;
   }

   private static void findAllThePaths(TreeNode cur, int currentPathSum,
                                       List<Integer> allPathSum){
      if(cur==null) return;

      currentPathSum = currentPathSum * 10 + cur.val;

      if(cur.left == null && cur.right == null ){
         allPathSum.add(currentPathSum);
      } else {
         findAllThePaths(cur.left,  currentPathSum, allPathSum);
         findAllThePaths(cur.right,  currentPathSum, allPathSum);
      }
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(0);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(1);
      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(5);
      System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
   }
}
