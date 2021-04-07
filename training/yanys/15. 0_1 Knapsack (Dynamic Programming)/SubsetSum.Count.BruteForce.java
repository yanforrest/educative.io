class SubsetSum {
   static int countSubsets(int[] num, int sum) {
      //TODO: Write - Your - Code
      return countSubsetsRecursive(num, sum, 0);

   }

   static int countSubsetsRecursive(int[] num, int sum, int index){
      if(index == num.length){
         if( sum == 0 ) return 1;
         else return 0;
      }

      int count1 =0, count2 = 0;
      count1 = countSubsetsRecursive(num, sum, index+1);
      if(sum >= num[index]) count2 = countSubsetsRecursive(num, sum-num[index], index+1);

      return count1+count2;
   }
   public static void main(String[] args) {
      SubsetSum ss = new SubsetSum();
      int[] num = { 1, 1, 2, 3 };
      System.out.println(ss.countSubsets(num, 4));
      num = new int[] { 1, 2, 7, 1, 5 };
      System.out.println(ss.countSubsets(num, 9));
   }
}