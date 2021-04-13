import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class CountUniqueTrees {
   public int countTrees(int n) {

      return countTrees(1,n);
   }
   public int countTrees(int begin, int end){
      int result =0;
      if( begin > end ) return 1;

      for(int i=begin; i <= end; i++ ){
         int left = countTrees(begin, i-1);
         int right = countTrees(i+1, end);
         result += left * right;
      }

      return result;
   }

   public static void main(String[] args) {
      CountUniqueTrees ct = new CountUniqueTrees();
      int count = ct.countTrees(2);
      System.out.print("Total trees: " + count);
   }
}
