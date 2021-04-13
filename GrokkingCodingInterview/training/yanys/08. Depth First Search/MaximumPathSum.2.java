class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class MaximumPathSum {

   private static int maximumPathSum = 0;

   public static int findMaximumPathSum(TreeNode root) {
      // TODO: Write your code here
      maximumPathSum=Integer.MIN_VALUE;
      calculateMaxPathSum(root);
      return maximumPathSum;
   }
   private static int calculateMaxPathSum( TreeNode cur)
   {
      if(cur==null )
            return 0;

      int leftPathSum=0;
      int rightPathSum=0;
      leftPathSum = calculateMaxPathSum(cur.left);
      rightPathSum = calculateMaxPathSum(cur.right);

      if(cur.left == null || cur.right == null)
         maximumPathSum = Math.max( maximumPathSum, cur.val);

      if(cur.left != null && cur.right != null )
         maximumPathSum = Math.max( maximumPathSum, leftPathSum +  rightPathSum + cur.val);

      return Math.max(leftPathSum, rightPathSum) + cur.val;
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