import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class CountAllPathSum {
   public static int countPaths(TreeNode root, int S) {
      // TODO: Write your code here
      List<List<Integer>> result = new ArrayList<>();
      List<List<Integer>> allPaths = new ArrayList<>();
      List<Integer> allSums = new ArrayList<>();
      findAllPaths(root, S, result,  allPaths, allSums );
      return result.size();
   }

   private static void findAllPaths(TreeNode cur, int sum,List<List<Integer>> result , List<List<Integer>> allPaths, List<Integer> allSums ){

      if(cur == null) return;

      if(cur.left == null && cur.right == null  ){
         List<Integer> temp = new ArrayList<>(); temp.add(cur.val); allPaths.add(temp);
         allSums.add(cur.val);
         if(cur.val==sum) {
            temp = new ArrayList<>(); temp.add(cur.val); result.add(temp);
         }
      }
      if(cur.left != null || cur.right != null)  {
         int start = allSums.size();
         findAllPaths(cur.left,  sum, result, allPaths,  allSums);
         findAllPaths(cur.right,  sum, result, allPaths,  allSums);

         for(int i= start; i < allSums.size(); i++ ){
            int value =  allSums.get(i) + cur.val;
            allPaths.get(i).add(cur.val);
            allSums.set(i, value);
            if (value == sum) result.add(allPaths.get(i));
         }
      }
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(12);
      root.left = new TreeNode(7);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(4);
      root.right.left = new TreeNode(10);
      root.right.right = new TreeNode(5);
      System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
   }
}