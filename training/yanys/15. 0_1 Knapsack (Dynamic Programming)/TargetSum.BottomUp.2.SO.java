class TargetSum {

   public int findTargetSubsets(int[] num, int s) {
      int sum = 0;
      for(int n: num)
         sum += n;

      if(sum < s || (s + sum)%2 == 1 ) return 0;

      return countSubsets(num, (s + sum)/2);
   }
   public int countSubsets(int[] num, int sum) {

      int n = num.length;
      int[] dp = new int[ sum + 1 ];


      dp[0] = 1;

      for(int j = 0; j <= sum; j++)
         if(j == num[0] ) dp[j] = 1 ;

      for(int i = 1; i < n ; i++) {
         for (int j = sum; j >= 0; j--) {
            if(j >= num[i]) dp[j] +=dp[j-num[i]];
         }
      }

      return dp[sum];
   }
   public static void main(String[] args) {
      TargetSum ts = new TargetSum();
      int[] num = {1, 1, 2, 3};
      System.out.println(ts.findTargetSubsets(num, 1));
      num = new int[]{1, 2, 7, 1};
      System.out.println(ts.findTargetSubsets(num, 9));
   }
}