import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class FindAllTreePaths {
   public static List<List<Integer>> findPaths(TreeNode root, int sum) {
      List<List<Integer>> allPaths = new ArrayList<>();
      List<Integer> currentPath = new ArrayList<>();
      if(root==null) return allPaths;

      findPathsRecursive(root, sum, currentPath, allPaths);
      return allPaths;
   }

   private static void findPathsRecursive( TreeNode root, int sum, List<Integer> currentPath,
                                           List<List<Integer>> allPaths)
   {

      currentPath.add(root.val);
      if(root.left==null && root.right==null && sum==root.val){
         allPaths.add(currentPath);
      }

      if(root.left!=null) {
         List<Integer> leftPath = new ArrayList<>(currentPath);
         findPathsRecursive(root.left, sum - root.val, leftPath, allPaths);
      }

      if(root.right!=null) {
         List<Integer> rightPath = new ArrayList<>(currentPath);
         findPathsRecursive(root.right, sum - root.val, rightPath, allPaths);
      }

   }


   public static void main(String[] args) {
      TreeNode root = new TreeNode(12);
      root.left = new TreeNode(7);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(4);
      root.right.left = new TreeNode(10);
      root.right.right = new TreeNode(5);
      int sum = 23;
      List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
      System.out.println("Tree paths with sum " + sum + ": " + result);
   }
}
