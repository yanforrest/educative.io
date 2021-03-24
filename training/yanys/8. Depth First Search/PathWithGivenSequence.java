import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class PathWithGivenSequence {
   public static boolean findPath(TreeNode root, int[] sequence) {
      // TODO: Write your code here
      return findRootToLeave( root, 0, sequence);
   }
   private static boolean findRootToLeave( TreeNode cur, int level, int[] sequence){
      if(cur==null) return false;

      if(level < sequence.length &&  sequence[level] != cur.val ) return false;

      if(cur.left==null && cur.right==null && level == sequence.length - 1  && sequence[level] == cur.val)
         return true;

      return  findRootToLeave( cur.left, level + 1 , sequence) || findRootToLeave( cur.right, level + 1 , sequence);


   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(0);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(1);
      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(5);

      System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
      System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
      System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 1 }));
      System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 5 }));
   }
}