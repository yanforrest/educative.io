import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class UniqueTrees {
   public static List<TreeNode> findUniqueTrees(int n) {
      List<TreeNode> result = new ArrayList<>();
      // TODO: Write your code here
      result = findUniqueTrees(1, n);

      return result;
   }

   public static List<TreeNode> findUniqueTrees(int start, int end) {
      List<TreeNode> result = new ArrayList<>();

      if(start > end ){
         result.add(null);
      }

      // TODO: Write your code here
      for(int i = start; i<= end; i++){
         List<TreeNode> leftTreeNodes = findUniqueTrees(start, i-1);
         List<TreeNode> rightTreeNodes = findUniqueTrees(i+1, end);
         for( TreeNode leftTree : leftTreeNodes ){
            for(  TreeNode rightTree : rightTreeNodes) {
               TreeNode head = new TreeNode(i);
               head.left = leftTree;
               head.right = rightTree;
               result.add(head);
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      List<TreeNode> result = UniqueTrees.findUniqueTrees(4);
      System.out.print("Total trees: " + result.size());
   }
}
