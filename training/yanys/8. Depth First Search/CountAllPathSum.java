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
      List<Integer> currentPath = new ArrayList<>();
      return countPathsRecursive(root, S, currentPath);
   }

   private static int countPathsRecursive(TreeNode cur,  int sum, List<Integer> currentPath ){

      if(cur == null) return 0;

      currentPath.add(cur.val);
      int value = 0;
      int pathsCount = 0;

      if(cur.left == null && cur.right == null  ){
         ListIterator<Integer> pathListIterator = currentPath.listIterator(currentPath.size());
         while(pathListIterator.hasPrevious()) {
            value = value + pathListIterator.previous();
            if(value == sum) {
               pathsCount++;
;              break;
            }
         }
      }
      if(cur.left != null || cur.right != null)  {
         pathsCount =  countPathsRecursive(cur.left, sum, currentPath) + countPathsRecursive(cur.right, sum, currentPath);
      }

      currentPath.remove(currentPath.size()-1);

      return pathsCount;
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