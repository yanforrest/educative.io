class TargetSum {

   public int findTargetSubsets(int[] num, int s) {
      int sum = 0;
      for(int i=0; i < num.length; i++)
         sum += num[i];

      return findTargetSubsetsRecursive(num, (s + sum)/2, 0);
   }
   public int findTargetSubsetsRecursive(int[] num, int s, int index) {

      if(index == num.length){
         if(s == 0) return 1;
         else return 0;
      }

      int result = 0;
      if(s >= num[index]) result = findTargetSubsetsRecursive(num, s-num[index], index+1);

      result += findTargetSubsetsRecursive(num, s, index+1);

      return result;
   }
   public static void main(String[] args) {
      TargetSum ts = new TargetSum();
      int[] num = {1, 1, 2, 3};
      System.out.println(ts.findTargetSubsets(num, 1));
      num = new int[]{1, 2, 7, 1};
      System.out.println(ts.findTargetSubsets(num, 9));
   }
}