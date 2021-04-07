class TargetSum {

   public int findTargetSubsets(int[] num, int s) {
      // TODO: Write your code here
      return findTargetSubsets(num, s, 0);
   }
   public int findTargetSubsets(int[] num, int s, int index) {

      if(index == num.length){
         if(s == 0) return 1;
         else return 0;
      }

      return findTargetSubsets(num, s-num[index], index+1) +
               findTargetSubsets(num, s+num[index], index+1);
   }
   public static void main(String[] args) {
      TargetSum ts = new TargetSum();
      int[] num = {1, 1, 2, 3};
      System.out.println(ts.findTargetSubsets(num, 1));
      num = new int[]{1, 2, 7, 1};
      System.out.println(ts.findTargetSubsets(num, 9));
   }
}