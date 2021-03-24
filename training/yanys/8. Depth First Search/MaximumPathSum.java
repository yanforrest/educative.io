class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class MaximumPathSum {

   private static int globalMaximumSum = 0;

   public static int findMaximumPathSum(TreeNode root) {
      // TODO: Write your code here
      globalMaximumSum=Integer.MIN_VALUE;
      findMaximumPathSumRecursive(root);
      return globalMaximumSum;
   }
   private static int findMaximumPathSumRecursive( TreeNode cur)
   {
      if(cur==null ) return 0;

      int maxPathSumFromLeftSide = findMaximumPathSumRecursive(cur.left);
      int maxPathSumFromRightSide = findMaximumPathSumRecursive(cur.right);

      maxPathSumFromLeftSide = Math.max(maxPathSumFromLeftSide, 0);
      maxPathSumFromRightSide = Math.max(maxPathSumFromRightSide, 0);

      int localNaximumSum = maxPathSumFromLeftSide +  maxPathSumFromRightSide + cur.val;

      globalMaximumSum = Math.max( globalMaximumSum, localNaximumSum);

      return Math.max(maxPathSumFromLeftSide, maxPathSumFromRightSide) + cur.val;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      root.right.left = new TreeNode(5);
      root.right.right = new TreeNode(6);
      root.right.left.left = new TreeNode(7);
      root.right.left.right = new TreeNode(8);
      root.right.right.left = new TreeNode(9);
      System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

      root = new TreeNode(-1);
      root.left = new TreeNode(-3);
      System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
   }
}