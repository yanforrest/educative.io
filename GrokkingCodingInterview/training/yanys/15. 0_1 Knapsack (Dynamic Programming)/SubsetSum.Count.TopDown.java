class SubsetSum {
   static int countSubsets(int[] num, int sum) {
      //TODO: Write - Your - Code
      Integer[][] dp = new Integer[num.length][sum+1];
      return countSubsetsRecursive(dp, num, sum, 0);

   }

   static int countSubsetsRecursive( Integer[][] dp, int[] num, int sum, int index){
      if(index == num.length){
         if( sum == 0 ) return 1;
         else return 0;
      }

      if(dp[index][sum]==null) {
         int count1 = 0, count2 = 0;
         count1 = countSubsetsRecursive(dp,num, sum, index + 1);
         if (sum >= num[index]) count2 = countSubsetsRecursive(dp, num, sum - num[index], index + 1);

         dp[index][sum] = count1 + count2;
      }else
         System.out.println("hit memory");

      return dp[index][sum];
   }
   public static void main(String[] args) {
      SubsetSum ss = new SubsetSum();
      int[] num = { 1, 1, 2, 3 };
      System.out.println(ss.countSubsets(num, 4));
      num = new int[] { 1, 2, 7, 1, 5 };
      System.out.println(ss.countSubsets(num, 9));
   }
}