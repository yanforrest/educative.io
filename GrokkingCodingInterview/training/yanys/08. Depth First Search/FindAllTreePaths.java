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

   private static void findPathsRecursive( TreeNode cur, int sum, List<Integer> currentPath,
                                           List<List<Integer>> allPaths)
   {
      if(cur== null) return ;

      currentPath.add(cur.val);

      if(cur.left==null && cur.right==null && sum==cur.val){
         allPaths.add(new ArrayList<>(currentPath));
      } else {
         findPathsRecursive(cur.left, sum - cur.val, currentPath, allPaths);
         findPathsRecursive(cur.right, sum - cur.val, currentPath, allPaths);
      }
      currentPath.remove(currentPath.size()-1);
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
