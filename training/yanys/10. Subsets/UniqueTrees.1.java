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
      if(start == end) {
         result.add(new TreeNode(start));
         return result;
      }

      // TODO: Write your code here
      for(int i = start; i<= end; i++){
         List<TreeNode> leftTreeNodes = findUniqueTrees(start, i-1);
         List<TreeNode> rightTreeNodes = findUniqueTrees(i+1, end);
         for( int l = 0; l < leftTreeNodes.size(); l++){
            for( int r = 0; r < rightTreeNodes.size(); r++) {
               TreeNode head = new TreeNode(i);
               head.left = leftTreeNodes.get(l);
               head.right = rightTreeNodes.get(r);
               result.add(head);
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      List<TreeNode> result = UniqueTrees.findUniqueTrees(5);
      System.out.print("Total trees: " + result.size() );
   }
}
