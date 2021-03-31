class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;

   TreeNode(int x) {
      val = x;
   }
};

class Measurement {
   int diameter;
   int radius;
   Measurement(int diameter, int radius){
      this.diameter = diameter;
      this.radius = radius;
   }
}
class TreeDiameter {

   public static int findDiameter(TreeNode root) {
      // TODO: Write your code here
      Measurement result = measure(root);
      return result.diameter;
   }
   public static Measurement measure(TreeNode cur) {

      if(cur==null) return new Measurement(0,0);

      if(cur.left == null && cur.right == null) return new Measurement(1,1);

      Measurement measureLeft = measure(cur.left);
      Measurement measureRight = measure(cur.right);

      int radius = Math.max(measureLeft.radius , measureRight.radius ) + 1;
      int diameter = 0;
      if(cur.left == null) {
         diameter = measureRight.diameter;
      } else if (cur.right == null){
         diameter = measureLeft.diameter;
      }else{
         diameter = Math.max(Math.max(measureLeft.diameter, measureRight.diameter), measureLeft.radius + measureRight.radius + 1);
      }
      return new Measurement(diameter, radius);

   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.right.left = new TreeNode(5);
      root.right.right = new TreeNode(6);
      System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
      root.left.left = null;
      root.right.left.left = new TreeNode(7);
      root.right.left.right = new TreeNode(8);
      root.right.right.left = new TreeNode(9);
      root.right.left.right.left = new TreeNode(10);
      root.right.right.left.left = new TreeNode(11);
      System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
   }
}
