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

      return findRootToLeafPathNumbers( root, 0);
   }

   private static int findRootToLeafPathNumbers(TreeNode cur, int currentPathSum){
      if(cur==null) return 0;

      currentPathSum = currentPathSum * 10 + cur.val;

      if(cur.left == null && cur.right == null ){
         return currentPathSum;
      }

      return findRootToLeafPathNumbers(cur.left,  currentPathSum)+
            findRootToLeafPathNumbers(cur.right,  currentPathSum);

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
