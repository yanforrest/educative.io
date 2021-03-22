import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode next;

   TreeNode(int x) {
      val = x;
      left = right = next = null;
   }

   public void printTree() {
      TreeNode current = this;
      System.out.print("Traversal using 'next' pointer: ");
      while (current != null) {
         System.out.print(current.val + " ");
         current = current.next;
      }
   }
};

class ConnectAllSiblings {
   public static void connect(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();

      TreeNode node = null, prev = null;
      queue.add(root);
      while(!queue.isEmpty()) {
         int length = queue.size();

         node = queue.poll();
         if (node.left != null) queue.add(node.left);
         if (node.right != null) queue.add(node.right);
         if (prev != null) prev.next = node;
         prev = node;
         node.next = null;

      }
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(12);
      root.left = new TreeNode(7);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(9);
      root.right.left = new TreeNode(10);
      root.right.right = new TreeNode(5);
      ConnectAllSiblings.connect(root);

      root.printTree();
   }
}